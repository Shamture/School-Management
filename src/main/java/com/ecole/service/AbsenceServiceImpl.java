package com.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Absence;
import com.ecole.beans.Eleve;
import com.ecole.beans.Utilisateur;
import com.ecole.dao.AbsenceDAO;

@Service
public class AbsenceServiceImpl implements AbsenceService {

	@Autowired
	private AbsenceDAO absenceDAO;
	@Autowired
	private Mail mail;
	@Autowired
	private UtilisateurService userServ;
	@Autowired
	private EleveService eleveServ;

	@Transactional
	public boolean ajouter(Absence abs) {
		Eleve eleve = eleveServ.getEleve(abs.getIdEleve());
		Utilisateur parent = userServ.getUser(eleve.getParent());
		String parentsMail = parent.getEmail();
		String message = "<p>" + eleve.getNom() + " " + eleve.getPrenom() + " a été absent le " + abs.getDate()
				+ " , vous pouvez connecter sur votre compte pour plus de detail.<p> ";
		String sujet = "Alert d'absence";
		mail.send(parentsMail, sujet, message);
		return absenceDAO.ajouter(abs);
	}

	@Transactional
	public boolean modifier(Absence absence) {
		return absenceDAO.modifier(absence);
	}

	@Transactional
	public boolean setVue(Absence abs) {
		abs.setVue(1);
		return absenceDAO.modifier(abs);
	}

	@Transactional
	public List<Absence> getAbsenceNonVue(int idEleve) {
		return absenceDAO.getAbsenceNonVue(idEleve);
	}

	@Transactional
	public List<Absence> getAllAbsence(int idEleve) {
		return absenceDAO.getAllAbsence(idEleve);
	}

}
