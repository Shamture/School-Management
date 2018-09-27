package com.ecole.service;

import java.util.List;

import com.ecole.beans.Eleve;
import com.ecole.data_transfer.EleveForm;

public interface EleveService {

	public boolean ajouter(EleveForm eleve);

	public Eleve getEleve(int id);

	public Eleve getEleveByCode(String code);

	public List<Eleve> getElevePourParent(int idParent);

	public List<Eleve> getTousEleve();

	public boolean deleteEleve(int id);

	public List<Eleve> getListElevePourClasse(int idGroupe, String anneeUniversitaire);

	public boolean modifier(EleveForm eleve);
}
