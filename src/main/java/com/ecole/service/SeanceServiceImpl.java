package com.ecole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Seance;
import com.ecole.dao.SeanceDAO;
import com.ecole.data_transfer.Emploi;

@Service
public class SeanceServiceImpl implements SeanceService {

	@Autowired
	private SeanceDAO seanceDAO;

	@Transactional
	public boolean ajouter(Seance seance) {
		return seanceDAO.ajouter(seance);
	}

	@Transactional
	public boolean modifier(Seance seance) {
		return seanceDAO.modifier(seance);
	}

	@Transactional
	public boolean supprimer(int id) {
		return seanceDAO.supprimer(id);
	}

	@Transactional
	public void ajouterEmploi(Emploi emploi) {

		if (emploi.getM_lundi_8() > 0) {
			int idMatiere = emploi.getM_lundi_8();
			int idProf = emploi.getP_lundi_8();
			String jour = "Lundi";
			String debut = "08:00:00";
			String fin = "09:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_mardi_8() > 0) {
			int idMatiere = emploi.getM_mardi_8();
			int idProf = emploi.getP_mardi_8();
			String jour = "Mardi";
			String debut = "08:00:00";
			String fin = "09:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_mercredi_8() > 0) {
			int idMatiere = emploi.getM_mercredi_8();
			int idProf = emploi.getP_mercredi_8();
			String jour = "Mercredi";
			String debut = "08:00:00";
			String fin = "09:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_jeudi_8() > 0) {
			int idMatiere = emploi.getM_jeudi_8();
			int idProf = emploi.getP_jeudi_8();
			String jour = "Jeudi";
			String debut = "08:00:00";
			String fin = "09:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_vendredi_8() > 0) {
			int idMatiere = emploi.getM_vendredi_8();
			int idProf = emploi.getP_vendredi_8();
			String jour = "Vendredi";
			String debut = "08:00:00";
			String fin = "09:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_lundi_10() > 0) {
			int idMatiere = emploi.getM_lundi_10();
			int idProf = emploi.getP_lundi_10();
			String jour = "Lundi";
			String debut = "09:45:00";
			String fin = "11:15:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_mardi_10() > 0) {
			int idMatiere = emploi.getM_mardi_10();
			int idProf = emploi.getP_mardi_10();
			String jour = "Mardi";
			String debut = "09:45:00";
			String fin = "11:15:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_mercredi_10() > 0) {
			int idMatiere = emploi.getM_mercredi_10();
			int idProf = emploi.getP_mercredi_10();
			String jour = "Mercredi";
			String debut = "09:45:00";
			String fin = "11:15:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_jeudi_10() > 0) {
			int idMatiere = emploi.getM_jeudi_10();
			int idProf = emploi.getP_jeudi_10();
			String jour = "Jeudi";
			String debut = "09:45:00";
			String fin = "11:15:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_vendredi_10() > 0) {
			int idMatiere = emploi.getM_vendredi_10();
			int idProf = emploi.getP_vendredi_10();
			String jour = "Vendredi";
			String debut = "09:45:00";
			String fin = "11:15:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}

		if (emploi.getM_lundi_12() > 0) {
			int idMatiere = emploi.getM_lundi_12();
			int idProf = emploi.getP_lundi_12();
			String jour = "Lundi";
			String debut = "11:30:00";
			String fin = "01:00:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_mardi_12() > 0) {
			int idMatiere = emploi.getM_mardi_12();
			int idProf = emploi.getP_mardi_12();
			String jour = "Mardi";
			String debut = "11:30:00";
			String fin = "01:00:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_mercredi_12() > 0) {
			int idMatiere = emploi.getM_mercredi_12();
			int idProf = emploi.getP_mercredi_12();
			String jour = "Mercredi";
			String debut = "11:30:00";
			String fin = "01:00:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_jeudi_12() > 0) {
			int idMatiere = emploi.getM_jeudi_12();
			int idProf = emploi.getP_jeudi_12();
			String jour = "Jeudi";
			String debut = "11:30:00";
			String fin = "01:00:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_vendredi_12() > 0) {
			int idMatiere = emploi.getM_vendredi_12();
			int idProf = emploi.getP_vendredi_12();
			String jour = "Vendredi";
			String debut = "11:30:00";
			String fin = "01:00:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}

		if (emploi.getM_lundi_2() > 0) {
			int idMatiere = emploi.getM_lundi_2();
			int idProf = emploi.getP_lundi_2();
			String jour = "Lundi";
			String debut = "02:00:00";
			String fin = "03:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_mardi_2() > 0) {
			int idMatiere = emploi.getM_mardi_2();
			int idProf = emploi.getP_mardi_2();
			String jour = "Mardi";
			String debut = "02:00:00";
			String fin = "03:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_mercredi_2() > 0) {
			int idMatiere = emploi.getM_mercredi_2();
			int idProf = emploi.getP_mercredi_2();
			String jour = "Mercredi";
			String debut = "02:00:00";
			String fin = "03:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_jeudi_2() > 0) {
			int idMatiere = emploi.getM_jeudi_2();
			int idProf = emploi.getP_jeudi_2();
			String jour = "Jeudi";
			String debut = "02:00:00";
			String fin = "03:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
		if (emploi.getM_vendredi_2() > 0) {
			int idMatiere = emploi.getM_vendredi_2();
			int idProf = emploi.getP_vendredi_2();
			String jour = "Vendredi";
			String debut = "02:00:00";
			String fin = "03:30:00";
			Seance seance = new Seance();
			seance.setClasse(emploi.getIdGroupe());
			seance.setProfesseur(idProf);
			seance.setMatiere(idMatiere);
			seance.setDebut(debut);
			seance.setFin(fin);
			seance.setJour(jour);
			ajouter(seance);
		}
	}

}
