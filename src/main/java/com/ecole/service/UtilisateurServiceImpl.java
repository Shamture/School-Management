package com.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Utilisateur;
import com.ecole.dao.UtilisateurDAO;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	UtilisateurDAO utilisateurDAO;

	@Transactional
	public Utilisateur login(String login, String pass) {

		return utilisateurDAO.login(login, pass);
	}

	@Transactional
	public boolean ajouterProfesseurs(Utilisateur user) {
		user.setRole("Professeur");
		return utilisateurDAO.ajouter(user);
	}

	@Transactional
	public boolean ajouterParent(Utilisateur user) {
		user.setRole("Parent");
		return utilisateurDAO.ajouter(user);

	}

	@Transactional
	public boolean modifier(Utilisateur user) {
		System.out.println("user service called");
		return utilisateurDAO.modifier(user);
	}

	@Transactional
	public boolean supprimer(int id) {
		return utilisateurDAO.supprimer(id);
	}

	@Transactional
	public Utilisateur getUser(int id) {

		return utilisateurDAO.getUser(id);
	}

	@Transactional
	public Utilisateur getUserByCin(String cin) {

		return utilisateurDAO.getUserByCin(cin);
	}

	@Transactional
	public List<Utilisateur> getListeProf() {
		return utilisateurDAO.getUsersByFilter("Professeur");
	}

	@Transactional
	public boolean checkField(String field, String value) {
		return utilisateurDAO.checkField(field, value);
	}

}
