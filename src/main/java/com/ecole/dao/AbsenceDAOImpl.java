package com.ecole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Absence;

@Repository
public class AbsenceDAOImpl implements AbsenceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean ajouter(Absence abs) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(abs);

		return true;
	}

	public boolean modifier(Absence absence) {
		Session session = sessionFactory.getCurrentSession();
		session.update(absence);

		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Absence> getAbsenceNonVue(int idEleve) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Absence where idEleve= :ide and vue=0 order by date desc");
		query.setParameter("ide", idEleve);
		List<Absence> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Absence> getAllAbsence(int idEleve) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Absence where idEleve= :ide order by date desc");
		query.setParameter("ide", idEleve);
		List<Absence> list = query.list();
		return list;
	}

}
