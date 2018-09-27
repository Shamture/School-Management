package com.ecole.service;

import java.util.List;

import com.ecole.beans.Utilisateur;

public interface UtilisateurService {

	public Utilisateur login(String login, String pass);

	public boolean ajouterProfesseurs(Utilisateur user);

	public boolean ajouterParent(Utilisateur user);

	public boolean modifier(Utilisateur user);

	public boolean supprimer(int id);

	public Utilisateur getUser(int id);

	public Utilisateur getUserByCin(String cin);

	public List<Utilisateur> getListeProf();

	public boolean checkField(String field, String value);

}
