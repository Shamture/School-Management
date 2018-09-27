package com.ecole.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ecole.beans.Contact;
import com.ecole.beans.Eleve;
import com.ecole.beans.Remarque;
import com.ecole.beans.Utilisateur;
import com.ecole.data_transfer.EleveForm;
import com.ecole.data_transfer.Emploi;
import com.ecole.data_transfer.RemarqueTransfer;
import com.ecole.service.ClasseService;
import com.ecole.service.ContactService;
import com.ecole.service.EleveService;
import com.ecole.service.GroupeService;
import com.ecole.service.Mail;
import com.ecole.service.MatiereService;
import com.ecole.service.RemarqueService;
import com.ecole.service.SeanceService;
import com.ecole.service.UtilisateurService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private GroupeService groupeService;

	@Autowired
	private EleveService eleveService;

	@Autowired
	private ClasseService classeService;

	@Autowired
	private ContactService contactService;

	@Autowired
	private RemarqueService remarqueService;
	@Autowired
	private Mail mail;
	@Autowired
	private MatiereService matiereService;
	@Autowired
	private SeanceService seanceService;

	@RequestMapping("/")
	public String home(Model model) {
		return "AdminHome";
	}

	@RequestMapping(value = "/creer_prof", method = RequestMethod.GET)
	public String ajouterProfesseurs(Model model) {
		Utilisateur newProf = new Utilisateur();
		model.addAttribute("newProf", newProf);
		return "AjouterProfesseurs";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");

	}

	@RequestMapping(value = "/creer_prof", method = RequestMethod.POST)
	public String processAjouterProfesseurs(@ModelAttribute("newProf") @Valid Utilisateur newProf, BindingResult result,
			Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "AjouterProfesseurs";
		}
		MultipartFile file = newProf.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		try {
			file.transferTo(new File(rootDirectory + "resources/img/" + newProf.getCin() + ".jpg"));
			if (utilisateurService.ajouterProfesseurs(newProf)) {
				String message = "<h1>Félicitation</h1>"
						+ "<br><br> <p>Votre compte a été bien crée  chez E-School , Vous pouvez connecter en utilisant les coordonnées suivantes : <br/>"
						+ "<strong>Login : </strong> " + newProf.getLogin() + " <br>"
						+ "<strong>Mot de passe : </strong> " + newProf.getPassword();
				mail.send(newProf.getEmail(), "Compte crée", message);
				return "redirect:/admin/liste_professeurs";
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return "AjouterProfesseurs";
	}

	@RequestMapping("/ajouter_eleve")
	public String ajouterEleve(ModelMap model, HttpServletRequest request) {
		request.setAttribute("groups", groupeService.getGroupsListNames());
		model.addAttribute("newEleve", new EleveForm());

		return "AjouterEleve";
	}

	@RequestMapping(value = "/ajouter_eleve", method = RequestMethod.POST)
	public String processAjouterEleve(@ModelAttribute("newEleve") @Valid EleveForm newEleve, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "AjouterEleve";
		}
		if (eleveService.ajouter(newEleve))
			return "redirect:/";
		return "AjouterEleve";
	}

	@RequestMapping("/liste_contact")
	public String displayListeContacts(Model model, HttpServletRequest request) {
		List<Contact> listContacts = contactService.getNouveauContact();
		request.setAttribute("listContacts", listContacts);
		return "ListContact";
	}

	@RequestMapping("/consulter_contact")
	public String displayContact(Model model, HttpServletRequest request) {
		int idContact = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactService.getContact(idContact);
		request.setAttribute("contact", contact);

		return "ConsulterContact";
	}

	@RequestMapping(value = "/consulter_contact", method = RequestMethod.POST)
	public String respondToContact(Model model, HttpServletRequest request) {
		String email = request.getParameter("mail");
		String message = request.getParameter("message");
		if (mail.send(email, "Reponse", message)) {
			request.setAttribute("sent", "true");
		} else {
			request.setAttribute("sent", "false");
		}
		Contact contact = contactService.getContact(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("contact", contact);
		contact.setVue(1);
		contactService.modifier(contact);
		return "ConsulterContact";
	}

	@RequestMapping("/list_remarques")
	public String displayRemarquesList(Model model, HttpServletRequest request) {
		List<Remarque> tmp = remarqueService.getListRemarqueNonVue();
		List<RemarqueTransfer> remqList = new ArrayList<RemarqueTransfer>();
		for (Remarque rmq : tmp) {
			RemarqueTransfer rmqt = new RemarqueTransfer();
			rmqt.setId(rmq.getId());
			rmqt.setDate(rmq.getDate());
			rmqt.setSujet(rmq.getSujet());
			rmqt.setVue(rmq.getVue_parent());
			rmqt.setEleve(eleveService.getEleve(rmq.getIdEleve()).getNom() + " "
					+ eleveService.getEleve(rmq.getIdEleve()).getPrenom());
			rmqt.setProfesseur(utilisateurService.getUser(rmq.getIdProf()).getNom() + " "
					+ utilisateurService.getUser(rmq.getIdProf()).getPrenom());
			remqList.add(rmqt);
		}
		request.setAttribute("rmqs", remqList);
		return "ListeRemarqueAdmin";
	}

	@RequestMapping("/consulterRemarque/{rmq}")
	public String consulterRemarque(Model model, @PathVariable("rmq") String rmq, HttpServletRequest request) {

		int rmqId = Integer.parseInt(rmq);
		Remarque remarque = remarqueService.getRemarque(rmqId);
		RemarqueTransfer rmqt = new RemarqueTransfer();
		rmqt.setId(remarque.getId());
		rmqt.setDate(remarque.getDate());
		rmqt.setSujet(remarque.getSujet());
		rmqt.setRemarque(remarque.getTexte());
		rmqt.setVue(remarque.getVue_parent());
		rmqt.setEleve(eleveService.getEleve(remarque.getIdEleve()).getNom() + " "
				+ eleveService.getEleve(remarque.getIdEleve()).getPrenom());
		rmqt.setProfesseur(utilisateurService.getUser(remarque.getIdProf()).getNom() + " "
				+ utilisateurService.getUser(remarque.getIdProf()).getPrenom());

		request.setAttribute("remarque", rmqt);

		remarque.setVue_admin(1);
		remarqueService.modifier(remarque);
		return "ConsulterRemarqueAdmin";
	}

	@RequestMapping("/liste_eleve")
	public String displayListeEleve(Model model, HttpServletRequest request) {
		List<Eleve> listEleve = eleveService.getTousEleve();
		request.setAttribute("eleves", listEleve);

		return "ListeEleveAdmin";
	}

	@RequestMapping("/modifier_eleve/{idEleve}")
	public String modifierEleve(Model model, @PathVariable("idEleve") String idEleve, HttpServletRequest request) {
		int idE = Integer.parseInt(idEleve);
		Eleve e = eleveService.getEleve(idE);
		Utilisateur parent = utilisateurService.getUser(e.getParent());
		EleveForm eleve = new EleveForm();
		eleve.setIdEleve(e.getIdEleve());
		eleve.setNom_eleve(e.getNom());
		eleve.setPrenom_eleve(e.getPrenom());
		eleve.setAdresse_eleve(e.getAdresse());
		eleve.setDateNaissance_eleve(e.getDate_inscrit());
		eleve.setDate_inscrit_eleve(e.getDate_inscrit());
		eleve.setCode_eleve(e.getCode());
		eleve.setEmail_eleve(e.getEmail());
		eleve.setNum_assurance_eleve(e.getNum_assurance());
		eleve.setLieu_naissance_eleve(e.getLieu_naissance());

		eleve.setIdParent(parent.getId());
		eleve.setAdresse_parent(parent.getAdresse());
		eleve.setCin_parent(parent.getCin());
		eleve.setEmail_parent(parent.getEmail());
		eleve.setNom_parent(parent.getNom());
		eleve.setPrenom_parent(parent.getPrenom());
		eleve.setPassword_parent(parent.getPassword());
		eleve.setTel_parent(parent.getTel());
		eleve.setLogin_parent(parent.getLogin());
		model.addAttribute("OldEleve", eleve);
		request.setAttribute("groups", groupeService.getGroupsListNames());

		return "ModifierEleve";
	}

	@RequestMapping(value = "/modifier_eleve/{idEleve}", method = RequestMethod.POST)
	public String processModifierEleve(@ModelAttribute("OldEleve") @Valid EleveForm oldEleve, BindingResult result,
			Model model, @PathVariable("idEleve") String idEleve, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "ModifierEleve";
		}
		if (eleveService.modifier(oldEleve))
			return "redirect:/admin/liste_eleve";
		return "ModifierEleve";

	}

	@RequestMapping("/liste_professeurs")
	public String diplayListprof(Model model, HttpServletRequest request) {
		request.setAttribute("profs", utilisateurService.getListeProf());
		return "ListeProfesseurs";
	}

	@RequestMapping("/modification_professeur/{idProf}")
	public String modifierProf(Model model, @PathVariable("idProf") String idProf, HttpServletRequest request) {
		int id = Integer.parseInt(idProf);
		Utilisateur prof = utilisateurService.getUser(id);
		request.setAttribute("prof", prof);

		return "ModifierProf";
	}

	@RequestMapping(value = "/modification_professeur/{idProf}", method = RequestMethod.POST)
	public String processmodifierProf(Model model, @PathVariable("idProf") String idProf, HttpServletRequest request) {
		int id = Integer.parseInt(idProf);
		Utilisateur user = utilisateurService.getUser(id);
		System.out.println(user);
		user.setCin(request.getParameter("cin"));
		user.setAdresse(request.getParameter("adresse"));
		user.setEmail(request.getParameter("email"));
		user.setIdentifiant_uniq(request.getParameter("identifiant_uniq"));
		user.setNom(request.getParameter("nom"));
		user.setPrenom(request.getParameter("prenom"));
		user.setTel(request.getParameter("tel"));
		if (utilisateurService.modifier(user)) {
			return "redirect:/admin/liste_professeurs";
		}
		return "ModifierProf";
	}

	@RequestMapping("/creer_emploi")
	public String creerEmploi(HttpServletRequest request, Model model) {
		request.setAttribute("listGroups", groupeService.getListeGroupe());
		request.setAttribute("listMatieres", matiereService.getListMatiere());
		request.setAttribute("listProf", utilisateurService.getListeProf());
		model.addAttribute("newEmploi", new Emploi());
		return "CreerEmploi";
	}

	@RequestMapping(value = "creer_emploi", method = RequestMethod.POST)
	public String processCreerEmploi(Model model, @ModelAttribute("newEmploi") @Valid Emploi emploi,
			HttpServletRequest request) {
		seanceService.ajouterEmploi(emploi);
		request.setAttribute("sucess", "true");
		request.setAttribute("listGroups", groupeService.getListeGroupe());
		request.setAttribute("listMatieres", matiereService.getListMatiere());
		request.setAttribute("listProf", utilisateurService.getListeProf());
		model.addAttribute("newEmploi", new Emploi());
		return "CreerEmploi";
	}
	/*
	 * REST web services for AJAX
	 */

	@RequestMapping(value = "/test_code_eleve", method = RequestMethod.GET)
	public @ResponseBody String testCodeEleve(HttpServletRequest request) {

		if (null != eleveService.getEleveByCode(request.getParameter("code_eleve"))) {
			System.out.println(eleveService.getEleveByCode(request.getParameter("code_eleve")).getNom());
			return "false";
		}

		return "true";
	}

	@RequestMapping("/test_cin_prof")
	public @ResponseBody String testCinProf(HttpServletRequest request) {

		if (null != utilisateurService.getUserByCin(request.getParameter("cin"))) {
			return "false";
		}
		return "true";
	}

	@RequestMapping("/test_identifiant")
	public @ResponseBody String testIdentifiantProf(HttpServletRequest request) {
		if (utilisateurService.checkField("identifiant_uniq", request.getParameter("identifiant_uniq")))
			return "false";
		return "true";
	}

	@RequestMapping(value = "/delete_eleve")
	public @ResponseBody String deleteEleve(HttpServletRequest request) {
		int idEleve = Integer.parseInt(request.getParameter("id"));
		if (eleveService.deleteEleve(idEleve))
			return "valide";
		return "erreur";
	}

	@RequestMapping(value = "/delete_prof")
	public @ResponseBody String deleteProf(HttpServletRequest request) {
		int idProf = Integer.parseInt(request.getParameter("id"));
		if (utilisateurService.supprimer(idProf))
			return "valide";
		return "erreur";
	}

	@RequestMapping("/test_cin_parent")
	public @ResponseBody String getParent(HttpServletRequest request) {
		String res = "";

		Utilisateur parent = utilisateurService.getUserByCin(request.getParameter("cin"));
		if (null != parent) {
			System.out.println(parent);
			String nom = "<p id='nom_r'>" + parent.getNom() + "</p>";
			String prenom = "<p id='prenom_r'>" + parent.getPrenom() + "</p>";
			String adresse = "<p id='adresse_r'>" + parent.getAdresse() + "</p>";
			String email = "<p id='email_r'>" + parent.getEmail() + "</p>";
			String login = "<p id='login_r'>" + parent.getLogin() + "</p>";
			String pass = "<p id='pass_r'>" + parent.getPassword() + "</p>";
			String tel = "<p id='tel_r'>" + parent.getTel() + "</p>";
			res = nom + prenom + adresse + email + login + pass + tel;
		}

		return res;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request) {

		return "CreerEmploi";
	}
}
