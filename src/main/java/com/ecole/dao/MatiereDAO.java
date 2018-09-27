package com.ecole.dao;

import java.util.List;

import com.ecole.beans.Matiere;

public interface MatiereDAO {

	public boolean ajouter(Matiere mat);

	public List<Matiere> getListMatiere();

	public Matiere getMatiere(int id);
}
