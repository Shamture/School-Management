package com.ecole.dao;

import java.util.List;

import com.ecole.beans.Groupe;

public interface GroupeDAO {

	public boolean ajouter(Groupe g);

	public List<Groupe> getGroupList();
}
