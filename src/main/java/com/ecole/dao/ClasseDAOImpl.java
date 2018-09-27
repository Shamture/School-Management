package com.ecole.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Classe;

@Repository
public class ClasseDAOImpl implements ClasseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean ajouter(Classe classe) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(classe);
		return true;
	}

	public Classe getClasseEleve(int idEleve, String anneeScolaire) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Classe where eleve= :ide and annee_scolaire= :ans");
		query.setParameter("ide", idEleve);
		query.setParameter("ans", anneeScolaire);
		Classe classe = (Classe) query.uniqueResult();

		return classe;
	}

}
