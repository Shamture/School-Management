package com.ecole.service;

import com.ecole.beans.Classe;

public interface ClasseService {

	public boolean ajouter(Classe classe);

	public String getNomClasseEleve(int idEleve);

	public Classe getClasseEleve(int idEleve);

}
