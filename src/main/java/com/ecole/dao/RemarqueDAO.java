package com.ecole.dao;

import java.util.List;

import com.ecole.beans.Remarque;

public interface RemarqueDAO {

	public boolean ajouter(Remarque remq);

	public boolean annuler(int id);

	public boolean modifier(Remarque remq);

	public Remarque getRemarque(int id);

	public List<Remarque> getListRemarqueNonVue(int idEleve);

	public List<Remarque> getListRemarqueNonVue();

	public List<Remarque> getListRemarquePourEleve(int idEleve);

}
