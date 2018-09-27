package com.ecole.service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Classe;
import com.ecole.dao.ClasseDAO;

@Service
public class ClasseServiceImpl implements ClasseService {

	@Autowired
	private ClasseDAO classeDAO;

	@Autowired
	private GroupeService groupeService;

	@Transactional
	public boolean ajouter(Classe classe) {

		return classeDAO.ajouter(classe);
	}

	@Transactional
	public String getNomClasseEleve(int idEleve) {
		LocalDate today = LocalDate.now();
		int year = today.get(ChronoField.YEAR);
		int month = today.get(ChronoField.MONTH_OF_YEAR);

		String anneeScolaire = "";
		if (month > 8)
			anneeScolaire = year + "/" + (year + 1);
		else
			anneeScolaire = (year - 1) + "/" + year;

		Classe classe = classeDAO.getClasseEleve(idEleve, anneeScolaire);
		Map<Integer, String> map = groupeService.getGroupsListNames();

		String res = map.get(classe.getGroupe());
		return res;
	}

	@Transactional
	public Classe getClasseEleve(int idEleve) {
		LocalDate today = LocalDate.now();
		int year = today.get(ChronoField.YEAR);
		int month = today.get(ChronoField.MONTH_OF_YEAR);

		String anneeScolaire = "";
		if (month > 8)
			anneeScolaire = year + "/" + (year + 1);
		else
			anneeScolaire = (year - 1) + "/" + year;

		return classeDAO.getClasseEleve(idEleve, anneeScolaire);
	}

}
