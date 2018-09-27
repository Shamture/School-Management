package com.ecole.dao;

import com.ecole.beans.Seance;

public interface SeanceDAO {

	public boolean ajouter(Seance seance);

	public boolean modifier(Seance seance);

	public boolean supprimer(int id);

}
