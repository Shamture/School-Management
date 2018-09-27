package com.ecole.controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecole.beans.Absence;
import com.ecole.beans.Contact;
import com.ecole.beans.Eleve;
import com.ecole.beans.Groupe;
import com.ecole.beans.Matiere;
import com.ecole.beans.Note;
import com.ecole.beans.Remarque;
import com.ecole.beans.Utilisateur;
import com.ecole.service.AbsenceService;
import com.ecole.service.ClasseService;
import com.ecole.service.ContactService;
import com.ecole.service.EleveService;
import com.ecole.service.GroupeService;
import com.ecole.service.MatiereService;
import com.ecole.service.NoteService;
import com.ecole.service.RemarqueService;
import com.ecole.service.UtilisateurService;

@Controller
@RequestMapping("/prof")
public class ProfController {

	@Autowired
	private MatiereService matiereService;
	@Autowired
	private AbsenceService absenceService;
	@Autowired
	private RemarqueService remarqueService;
	@Autowired
	private EleveService eleveService;
	@Autowired
	private ClasseService classeService;
	@Autowired
	private GroupeService groupeService;
	@Autowired
	private NoteService noteService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private ContactService contactService;

	@RequestMapping("/")
	public String home(Model model) {

		return "ProfHome";
	}

	@RequestMapping("/postuler_absence")
	public String postulerAbsence(Model model, HttpServletRequest request) {
		request.setAttribute("matieres", matiereService.getListMatiere());
		int idEleve = Integer.parseInt(request.getParameter("idEleve"));
		Eleve eleve = eleveService.getEleve(idEleve);
		request.setAttribute("eleve", eleve);
		return "PostulerAbsence";
	}

	@RequestMapping(value = "/postuler_absence", method = RequestMethod.POST)
	public String processPostulerAbsence(Model model, HttpServletRequest request) {
		int idEleve = Integer.parseInt(request.getParameter("idEleve"));

		HttpSession session = request.getSession();
		int idProf = (Integer) session.getAttribute("id");
		String date = request.getParameter("date");
		int idMatiere = Integer.parseInt(request.getParameter("matiere"));
		Absence abs = new Absence();
		abs.setDate(date);
		abs.setIdProf(idProf);
		abs.setIdEleve(idEleve);
		abs.setMatiere(idMatiere);
		request.setAttribute("matieres", matiereService.getListMatiere());
		if (absenceService.ajouter(abs)) {
			request.setAttribute("added", "true");
		} else {
			request.setAttribute("added", "false");
		}
		Eleve eleve = eleveService.getEleve(idEleve);
		request.setAttribute("eleve", eleve);
		return "PostulerAbsence";
	}

	@RequestMapping("/postuler_remarque")
	public String postulerRemarque(Model model, HttpServletRequest request) {
		int idEleve = Integer.parseInt(request.getParameter("idEleve"));
		Eleve eleve = eleveService.getEleve(idEleve);
		request.setAttribute("eleve", eleve);

		return "PostulerRemarque";
	}

	@RequestMapping(value = "/postuler_remarque", method = RequestMethod.POST)
	public String processPostulerRemarque(Model model, HttpServletRequest request) {
		int idEleve = Integer.parseInt(request.getParameter("idEleve"));

		HttpSession session = request.getSession();
		int idProf = (Integer) session.getAttribute("id");
		String sujet = request.getParameter("sujet");
		String texte = request.getParameter("texte");
		Remarque remq = new Remarque();
		remq.setIdEleve(idEleve);
		remq.setIdProf(idProf);
		remq.setSujet(sujet);
		remq.setTexte(texte);
		if (remarqueService.ajouter(remq)) {
			request.setAttribute("added", "true");
		} else {
			request.setAttribute("added", "false");
		}
		request.setAttribute("eleve", eleveService.getEleve(idEleve));
		return "PostulerRemarque";
	}

	@RequestMapping("/contact")
	public String envoyerContact(Model model, HttpServletRequest request) {

		return "ContactProf";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String processEnvoyerContact(Model model, HttpServletRequest request) {
		String sujet = request.getParameter("sujet");
		String message = request.getParameter("message");
		HttpSession session = request.getSession();
		int idProf = (Integer) session.getAttribute("id");
		Utilisateur user = utilisateurService.getUser(idProf);
		Contact contact = new Contact();
		contact.setSujet(sujet);
		contact.setTexte(message);
		contact.setEmail(user.getEmail());
		LocalDate today = LocalDate.now();
		int year = today.get(ChronoField.YEAR);
		int month = today.get(ChronoField.MONTH_OF_YEAR);
		int day = today.get(ChronoField.DAY_OF_MONTH);
		String date = year + "-" + month + "-" + day;
		contact.setDate(date);
		if (contactService.ajouter(contact)) {
			request.setAttribute("sent", "true");
		} else {
			request.setAttribute("sent", "false");
		}

		return "ContactProf";
	}

	/* Ajax Part */

	@RequestMapping("/chercher_etudiant")
	public @ResponseBody String getTime(HttpServletRequest request) {
		String code = request.getParameter("code");
		Eleve eleve = eleveService.getEleveByCode(code);

		if (null != eleve) {

			String classe = classeService.getNomClasseEleve(eleve.getIdEleve());
			String result = "<p class='hidden' id='id-e'>" + eleve.getIdEleve() + "</p>Nom :  <small>" + eleve.getNom()
					+ "</small><br/>Prenom :  <small>" + eleve.getPrenom() + "</small><br/>Date Naissance : <small>"
					+ eleve.getDateNaissance() + "</small><br/>Classe : <small>" + classe + "</small>";
			return result;
		}
		return "erreur";
	}

	@RequestMapping("/choisir_groupe")
	public String choisirClasse(Model model, HttpServletRequest request) {

		List<Groupe> listGroupe = groupeService.getListeGroupe();
		List<Matiere> listMatiere = matiereService.getListMatiere();

		request.setAttribute("listGroups", listGroupe);
		request.setAttribute("listMatieres", listMatiere);
		return "ChoisirClasse";
	}

	@RequestMapping("/inserer_notes")
	public String ajouterNotes(Model model, HttpServletRequest request) {
		String type = request.getParameter("type");
		int groupe = Integer.parseInt(request.getParameter("classe"));
		int matiere = Integer.parseInt(request.getParameter("matiere"));
		LocalDate today = LocalDate.now();
		int year = today.get(ChronoField.YEAR);
		int month = today.get(ChronoField.MONTH_OF_YEAR);
		String anneeScolaire = "";
		if (month > 8)
			anneeScolaire = year + "/" + (year + 1);
		else
			anneeScolaire = (year - 1) + "/" + (year);
		List<Eleve> listEleve = eleveService.getListElevePourClasse(groupe, anneeScolaire);
		request.setAttribute("listEleve", listEleve);
		request.setAttribute("type", type);
		return "InsererNotes";
	}

	@RequestMapping(value = "/inserer_notes", method = RequestMethod.POST)
	public String processAjouterNotes(Model model, HttpServletRequest request) {
		String type = request.getParameter("type");
		int matiere = Integer.parseInt(request.getParameter("matiere"));
		int taille = Integer.parseInt(request.getParameter("taille"));

		for (int i = 1; i <= taille; i++) {
			int idEleve = Integer.parseInt(request.getParameter("id" + i));
			float valeur = Float.parseFloat(request.getParameter("note" + i));
			Note note = new Note();
			note.setIdEleve(idEleve);
			note.setIdMatiere(matiere);
			note.setValeur(valeur);
			note.setType(type);
			note.setIdClasse(classeService.getClasseEleve(idEleve).getIdClasse());
			noteService.ajouter(note);
		}
		request.setAttribute("added", "true");
		return "InsererNotes";
	}

	@RequestMapping("/selectionner_classe")
	public String selectionnerClasse(Model model, HttpServletRequest request) {
		List<Groupe> groupsList = groupeService.getListeGroupe();
		request.setAttribute("groups", groupsList);
		return "SelectionnerClasse";
	}

	@RequestMapping("/liste_eleve")
	public String displayListeEleve(Model model, HttpServletRequest request) {
		int groupe = Integer.parseInt(request.getParameter("classe"));
		LocalDate today = LocalDate.now();
		int year = today.get(ChronoField.YEAR);
		int month = today.get(ChronoField.MONTH_OF_YEAR);
		String anneeScolaire = "";
		if (month > 8)
			anneeScolaire = year + "/" + (year + 1);
		else
			anneeScolaire = (year - 1) + "/" + (year);
		List<Eleve> listEleve = eleveService.getListElevePourClasse(groupe, anneeScolaire);
		request.setAttribute("listEleve", listEleve);
		return "ListeEleve";
	}

}
