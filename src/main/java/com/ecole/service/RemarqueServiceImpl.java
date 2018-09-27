package com.ecole.service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Remarque;
import com.ecole.dao.RemarqueDAO;

@Service
public class RemarqueServiceImpl implements RemarqueService {

	@Autowired
	private RemarqueDAO remarqueDAO;

	@Transactional
	public boolean ajouter(Remarque remq) {
		LocalDate today = LocalDate.now();
		int year = today.get(ChronoField.YEAR);
		int month = today.get(ChronoField.MONTH_OF_YEAR);
		int day = today.get(ChronoField.DAY_OF_MONTH);
		String date = year + "-" + month + "-" + day;
		remq.setDate(date);
		return remarqueDAO.ajouter(remq);
	}

	@Transactional
	public boolean annuler(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	public boolean modifier(Remarque remq) {

		return remarqueDAO.modifier(remq);
	}

	@Transactional
	public Remarque getRemarque(int id) {

		return remarqueDAO.getRemarque(id);
	}

	@Transactional
	public List<Remarque> getListRemarqueNonVue(int idEleve) {

		return remarqueDAO.getListRemarqueNonVue(idEleve);
	}

	@Transactional
	public List<Remarque> getListRemarqueNonVue() {

		return remarqueDAO.getListRemarqueNonVue();
	}

	@Transactional
	public List<Remarque> getListRemarquePourEleve(int idEleve) {
		List<Remarque> list = remarqueDAO.getListRemarquePourEleve(idEleve);

		return list;
	}

}
