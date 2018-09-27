package com.ecole.controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecole.beans.Absence;
import com.ecole.beans.Contact;
import com.ecole.beans.Eleve;
import com.ecole.beans.Remarque;
import com.ecole.beans.Utilisateur;
import com.ecole.data_transfer.AbsenceTransfer;
import com.ecole.data_transfer.RemarqueTransfer;
import com.ecole.service.AbsenceService;
import com.ecole.service.ContactService;
import com.ecole.service.EleveService;
import com.ecole.service.GroupeService;
import com.ecole.service.MatiereService;
import com.ecole.service.RemarqueService;
import com.ecole.service.UtilisateurService;

@Controller
@RequestMapping("/parent")
public class ParentController {

	@Autowired
	private EleveService eleveServ;
	@Autowired
	private AbsenceService absenceServ;
	@Autowired
	private RemarqueService remarqueServ;
	@Autowired
	private UtilisateurService userService;
	@Autowired
	private ContactService contactService;
	@Autowired
	private MatiereService matiereService;
	@Autowired
	private GroupeService groupeService;

	@RequestMapping("/")
	public String home(Model model, HttpServletRequest request) {
		addRequiredInfo(request);

		return "ParentHome";
	}

	@RequestMapping("/contact")
	public String envoyerContact(Model model, HttpServletRequest request) {
		addRequiredInfo(request);
		return "ContactParent";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String processEnvoyerContact(Model model, HttpServletRequest request) {
		String sujet = request.getParameter("sujet");
		String message = request.getParameter("message");
		HttpSession session = request.getSession();
		int idParent = (Integer) session.getAttribute("id");
		Utilisateur user = userService.getUser(idParent);
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

		return "ContactParent";
	}

	@RequestMapping("/liste_absence")
	public String listeAbsence(Model model, HttpServletRequest request) {
		addRequiredInfo(request);
		HttpSession session = request.getSession();
		int idParent = (Integer) session.getAttribute("id");
		List<Eleve> list = eleveServ.getElevePourParent(idParent);
		List<Absence> listAbsence = new ArrayList<Absence>();
		for (Eleve eleve : list) {
			listAbsence.addAll(absenceServ.getAllAbsence(eleve.getIdEleve()));
		}
		List<AbsenceTransfer> listAbsFinal = new ArrayList<AbsenceTransfer>();
		for (Absence abs : listAbsence) {
			AbsenceTransfer abst = new AbsenceTransfer();
			abst.setDate(abs.getDate());
			abst.setEleve(eleveServ.getEleve(abs.getIdEleve()).getNom() + " "
					+ eleveServ.getEleve(abs.getIdEleve()).getPrenom());
			abst.setProfesseur(userService.getUser(abs.getIdProf()).getNom() + " "
					+ userService.getUser(abs.getIdProf()).getPrenom());
			abst.setMatiere(matiereService.getMatiere(abs.getMatiere()).getNom());
			abst.setVue((byte) abs.getVue());
			listAbsFinal.add(abst);
		}
		request.setAttribute("absences", listAbsFinal);

		for (Absence abs : listAbsence) {
			if (abs.getVue() == 0)
				absenceServ.setVue(abs);
		}

		return "ListeAbsence";
	}

	@RequestMapping("/liste_remarque")
	public String listeRemarque(Model model, HttpServletRequest request) {
		addRequiredInfo(request);
		HttpSession session = request.getSession();
		int idParent = (Integer) session.getAttribute("id");
		List<Eleve> list = eleveServ.getElevePourParent(idParent);
		List<RemarqueTransfer> remqList = new ArrayList<RemarqueTransfer>();
		for (Eleve eleve : list) {
			List<Remarque> tmp = remarqueServ.getListRemarquePourEleve(eleve.getIdEleve());
			for (Remarque rmq : tmp) {
				RemarqueTransfer rmqt = new RemarqueTransfer();
				rmqt.setId(rmq.getId());
				rmqt.setDate(rmq.getDate());
				rmqt.setSujet(rmq.getSujet());
				rmqt.setVue(rmq.getVue_parent());
				rmqt.setEleve(eleveServ.getEleve(rmq.getIdEleve()).getNom() + " "
						+ eleveServ.getEleve(rmq.getIdEleve()).getPrenom());
				rmqt.setProfesseur(userService.getUser(rmq.getIdProf()).getNom() + " "
						+ userService.getUser(rmq.getIdProf()).getPrenom());
				remqList.add(rmqt);

			}
		}

		request.setAttribute("remarques", remqList);

		return "ListeRemarques";
	}

	@RequestMapping("/consulterRemarque/{rmq}")
	public String consulterRemarque(Model model, @PathVariable("rmq") String rmq, HttpServletRequest request) {
		addRequiredInfo(request);
		int rmqId = Integer.parseInt(rmq);
		Remarque remarque = remarqueServ.getRemarque(rmqId);
		RemarqueTransfer rmqt = new RemarqueTransfer();
		rmqt.setId(remarque.getId());
		rmqt.setDate(remarque.getDate());
		rmqt.setSujet(remarque.getSujet());
		rmqt.setRemarque(remarque.getTexte());
		rmqt.setVue(remarque.getVue_parent());
		rmqt.setEleve(eleveServ.getEleve(remarque.getIdEleve()).getNom() + " "
				+ eleveServ.getEleve(remarque.getIdEleve()).getPrenom());
		rmqt.setProfesseur(userService.getUser(remarque.getIdProf()).getNom() + " "
				+ userService.getUser(remarque.getIdProf()).getPrenom());

		request.setAttribute("remarque", rmqt);

		remarque.setVue_parent(1);
		remarqueServ.modifier(remarque);
		return "ConsulterRemarque";
	}

	public void addRequiredInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int idParent = (Integer) session.getAttribute("id");
		List<Eleve> list = eleveServ.getElevePourParent(idParent);
		int numAbsence = 0;
		for (Eleve eleve : list) {
			numAbsence += absenceServ.getAbsenceNonVue(eleve.getIdEleve()).size();
		}
		int numRemarque = 0;
		for (Eleve eleve : list) {
			numRemarque += remarqueServ.getListRemarqueNonVue(eleve.getIdEleve()).size();
		}

		request.setAttribute("numAbsence", numAbsence);
		request.setAttribute("numRemarque", numRemarque);
	}
}
