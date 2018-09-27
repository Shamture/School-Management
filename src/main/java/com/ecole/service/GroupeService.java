package com.ecole.service;

import java.util.List;
import java.util.Map;

import com.ecole.beans.Groupe;

public interface GroupeService {

	public boolean ajouter(Groupe g);

	public Map<Integer, String> getGroupsListNames();

	public List<Groupe> getListeGroupe();
}
