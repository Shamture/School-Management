package com.ecole.service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Classe;
import com.ecole.beans.Eleve;
import com.ecole.beans.Utilisateur;
import com.ecole.dao.EleveDAO;
import com.ecole.data_transfer.EleveForm;

@Service
public class EleveServiceImpl implements EleveService {

	@Autowired
	private EleveDAO eleveDAO;

	@Autowired
	UtilisateurService utilisateurService;

	@Autowired
	ClasseService classeService;

	@Transactional
	public boolean ajouter(EleveForm eleveForm) {
		Utilisateur parent = new Utilisateur();
		parent.setNom(eleveForm.getNom_parent());
		parent.setPrenom(eleveForm.getPrenom_parent());
		parent.setAdresse(eleveForm.getAdresse_parent());
		parent.setCin(eleveForm.getCin_parent());
		parent.setEmail(eleveForm.getEmail_parent());
		parent.setLogin(eleveForm.getLogin_parent());
		parent.setPassword(eleveForm.getPassword_parent());

		parent.setTel(eleveForm.getTel_parent());
		if (null != utilisateurService.getUserByCin(eleveForm.getCin_parent())
				|| utilisateurService.ajouterParent(parent)) {
			eleveForm.setIdParent(utilisateurService.getUserByCin(parent.getCin()).getId());
			Eleve eleve = new Eleve();
			eleve.setAdresse(eleveForm.getAdresse_eleve());
			eleve.setCode(eleveForm.getCode_eleve());
			LocalDate today = LocalDate.now();
			int year = today.get(ChronoField.YEAR);
			int month = today.get(ChronoField.MONTH_OF_YEAR);
			int day = today.get(ChronoField.DAY_OF_MONTH);
			eleve.setDate_inscrit(year + "-" + month + "-" + day);
			eleve.setDateNaissance(eleveForm.getDateNaissance_eleve());
			eleve.setEmail(eleveForm.getEmail_eleve());
			eleve.setLieu_naissance(eleveForm.getLieu_naissance_eleve());
			eleve.setNom(eleveForm.getNom_eleve());
			eleve.setPrenom(eleveForm.getPrenom_eleve());
			eleve.setNum_assurance(eleveForm.getNum_assurance_eleve());
			eleve.setParent(eleveForm.getIdParent());
			if (eleveDAO.ajouter(eleve)) {
				int idEleve = eleveDAO.getEleveByCode(eleveForm.getCode_eleve()).getIdEleve();
				Classe classe = new Classe();
				classe.setGroupe(eleveForm.getGroupe_eleve());
				classe.setEleve(idEleve);
				classe.setAnneeScolaire(year + "/" + (year++));
				if (classeService.ajouter(classe)) {
					return true;
				} else {
					eleveDAO.deleteEleve(idEleve);
				}
			} else {
				utilisateurService.supprimer(eleveForm.getIdParent());
			}

		}

		return false;
	}

	@Transactional
	public Eleve getEleve(int id) {
		return eleveDAO.getEleve(id);
	}

	@Transactional
	public List<Eleve> getElevePourParent(int idParent) {
		return eleveDAO.getElevePourParent(idParent);
	}

	@Transactional
	public List<Eleve> getTousEleve() {
		return eleveDAO.getTousEleve();
	}

	@Transactional
	public boolean deleteEleve(int id) {
		return eleveDAO.deleteEleve(id);
	}

	@Transactional
	public Eleve getEleveByCode(String code) {

		return eleveDAO.getEleveByCode(code);
	}

	@Transactional
	public List<Eleve> getListElevePourClasse(int idGroupe, String anneeUniversitaire) {

		return eleveDAO.getListElevePourClasse(idGroupe, anneeUniversitaire);
	}

	@Transactional
	public boolean modifier(EleveForm eleveForm) {
		Utilisateur parent = utilisateurService.getUserByCin(eleveForm.getCin_parent());
		parent.setNom(eleveForm.getNom_parent());
		parent.setPrenom(eleveForm.getPrenom_parent());
		parent.setAdresse(eleveForm.getAdresse_parent());
		parent.setCin(eleveForm.getCin_parent());
		parent.setEmail(eleveForm.getEmail_parent());
		parent.setTel(eleveForm.getTel_parent());

		utilisateurService.modifier(parent);
		Eleve eleve = eleveDAO.getEleveByCode(eleveForm.getCode_eleve());

		eleve.setAdresse(eleveForm.getAdresse_eleve());

		eleve.setDateNaissance(eleveForm.getDateNaissance_eleve());
		eleve.setEmail(eleveForm.getEmail_eleve());
		eleve.setLieu_naissance(eleveForm.getLieu_naissance_eleve());
		eleve.setNom(eleveForm.getNom_eleve());
		eleve.setPrenom(eleveForm.getPrenom_eleve());
		eleve.setNum_assurance(eleveForm.getNum_assurance_eleve());
		eleveDAO.modifier(eleve);
		return true;

	}

}
