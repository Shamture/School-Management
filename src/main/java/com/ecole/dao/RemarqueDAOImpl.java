package com.ecole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Remarque;

@Repository
public class RemarqueDAOImpl implements RemarqueDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean ajouter(Remarque remq) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(remq);
		return true;
	}

	public boolean annuler(int id) {
		Session session = sessionFactory.getCurrentSession();
		Remarque rmq = (Remarque) session.load(Remarque.class, new Integer(id));
		if (null != rmq)
			session.delete(rmq);
		return false;
	}

	public boolean modifier(Remarque remq) {
		Session session = sessionFactory.getCurrentSession();
		session.update(remq);
		return true;
	}

	public Remarque getRemarque(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Remarque where idRemarque= :id");
		query.setParameter("id", id);
		return (Remarque) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Remarque> getListRemarqueNonVue(int idEleve) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Remarque where idEleve = :ide and vue_parent=0 order by date desc");
		query.setParameter("ide", idEleve);
		List<Remarque> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Remarque> getListRemarqueNonVue() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Remarque where vue_admin=0 order by date desc");

		List<Remarque> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Remarque> getListRemarquePourEleve(int idEleve) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Remarque where idEleve = :ide order by date desc");
		query.setParameter("ide", idEleve);
		List<Remarque> list = query.list();
		return list;
	}

}
