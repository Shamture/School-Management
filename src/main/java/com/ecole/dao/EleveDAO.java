package com.ecole.dao;

import java.util.List;

import com.ecole.beans.Eleve;

public interface EleveDAO {

	public boolean ajouter(Eleve eleve);

	public Eleve getEleve(int id);

	public Eleve getEleveByCode(String code);

	public List<Eleve> getElevePourParent(int idParent);

	public List<Eleve> getTousEleve();

	public boolean deleteEleve(int id);

	public List<Eleve> getListElevePourClasse(int idGroupe, String anneeUniversitaire);

	public boolean modifier(Eleve eleve);
}
