package com.ecole.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Seance;

@Repository
public class SeanceDAOImpl implements SeanceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean ajouter(Seance seance) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(seance);
		return true;
	}

	public boolean modifier(Seance seance) {
		Session session = sessionFactory.getCurrentSession();
		session.update(seance);
		return true;
	}

	public boolean supprimer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
