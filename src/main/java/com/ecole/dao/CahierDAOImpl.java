package com.ecole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Cahier;

@Repository
public class CahierDAOImpl implements CahierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean ajouter(Cahier cahier) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(cahier);
		return true;
	}

	public Cahier getLastForClass(int groupe) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cahier where");
		return null;
	}

	public List<Cahier> getListCahier(int prof) {

		return null;
	}

}
