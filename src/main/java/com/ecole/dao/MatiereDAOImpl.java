package com.ecole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Matiere;

@Repository
public class MatiereDAOImpl implements MatiereDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean ajouter(Matiere mat) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(mat);
		return true;
	}

	public List<Matiere> getListMatiere() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Matiere");
		List<Matiere> list = query.list();
		return list;
	}

	public Matiere getMatiere(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Matiere where idMatiere = :idm");
		query.setParameter("idm", id);
		return (Matiere) query.uniqueResult();
	}

}
