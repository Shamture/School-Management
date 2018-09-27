package com.ecole.service;

import java.util.List;

import com.ecole.beans.Matiere;

public interface MatiereService {

	public boolean ajouter(Matiere mat);

	public List<Matiere> getListMatiere();

	public Matiere getMatiere(int id);
}
