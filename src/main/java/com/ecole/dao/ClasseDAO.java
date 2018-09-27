package com.ecole.dao;

import com.ecole.beans.Classe;

public interface ClasseDAO {

	public boolean ajouter(Classe classe);

	public Classe getClasseEleve(int idEleve, String anneeScolaire);

}
