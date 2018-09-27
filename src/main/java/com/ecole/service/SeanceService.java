package com.ecole.service;

import com.ecole.beans.Seance;
import com.ecole.data_transfer.Emploi;

public interface SeanceService {

	public boolean ajouter(Seance seance);

	public boolean modifier(Seance seance);

	public boolean supprimer(int id);

	public void ajouterEmploi(Emploi emploi);

}
