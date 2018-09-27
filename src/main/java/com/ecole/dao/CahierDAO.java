package com.ecole.dao;

import java.util.List;

import com.ecole.beans.Cahier;

public interface CahierDAO {

	public boolean ajouter(Cahier cahier);

	public Cahier getLastForClass(int groupe);

	public List<Cahier> getListCahier(int prof);

}
