package com.ecole.dao;

import java.util.List;

import com.ecole.beans.Utilisateur;

public interface UtilisateurDAO {

	public Utilisateur login(String login, String pass);

	public boolean ajouter(Utilisateur user);

	public boolean modifier(Utilisateur user);

	public boolean supprimer(int id);

	public Utilisateur getUser(int id);

	public Utilisateur getUserByCin(String cin);

	public List<Utilisateur> getUsersByFilter(String filter);

	public boolean checkField(String field, String value);

}
