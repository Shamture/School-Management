package com.ecole.service;

import java.util.List;

import com.ecole.beans.Remarque;

public interface RemarqueService {

	public boolean ajouter(Remarque remq);

	public boolean annuler(int id);

	public boolean modifier(Remarque remq);

	public Remarque getRemarque(int id);

	public List<Remarque> getListRemarqueNonVue(int idEleve);

	public List<Remarque> getListRemarqueNonVue();

	public List<Remarque> getListRemarquePourEleve(int idEleve);
}
