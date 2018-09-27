package com.ecole.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecole.beans.Eleve;
import com.ecole.beans.Utilisateur;
import com.ecole.service.AbsenceService;
import com.ecole.service.ContactService;
import com.ecole.service.EleveService;
import com.ecole.service.RemarqueService;
import com.ecole.service.UtilisateurService;

@Controller
public class Main {

	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private ContactService contactService;
	@Autowired
	private RemarqueService remarqueService;
	@Autowired
	private EleveService eleveServ;
	@Autowired
	private AbsenceService absenceServ;
	@Autowired
	private RemarqueService remarqueServ;

	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		if ("Admin".equals(session.getAttribute("role"))) {
			int numContact = contactService.getNouveauContact().size();
			request.setAttribute("contacts", numContact);
			int numRmq = remarqueService.getListRemarqueNonVue().size();
			request.setAttribute("rmqs", numRmq);
			return "AdminHome";
		} else if ("Parent".equals(session.getAttribute("role"))) {

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
			return "ParentHome";
		} else if ("Professeur".equals(session.getAttribute("role"))) {
			return "ProfHome";
		}
		return "index2";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		Utilisateur user = utilisateurService.login(login, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", user.getId());
			session.setAttribute("role", user.getRole());
			session.setAttribute("nom", user.getNom());
			session.setAttribute("prenom", user.getPrenom());
			return "redirect:/";
		} else {
			request.setAttribute("res", "false");
		}

		return "index2";
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/404")
	public String get404() {

		return "404";
	}

}
