package com.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Matiere;
import com.ecole.dao.MatiereDAO;

@Service
public class MatiereServiceImpl implements MatiereService {

	@Autowired
	private MatiereDAO matiereDAO;

	@Transactional
	public boolean ajouter(Matiere mat) {
		return matiereDAO.ajouter(mat);
	}

	@Transactional
	public List<Matiere> getListMatiere() {

		return matiereDAO.getListMatiere();
	}

	@Transactional
	public Matiere getMatiere(int id) {
		return matiereDAO.getMatiere(id);
	}

}
