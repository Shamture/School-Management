package com.ecole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Utilisateur;

@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Utilisateur login(String login, String pass) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Utilisateur where login= :log and password = :pass");
		query.setParameter("log", login);
		query.setParameter("pass", pass);
		Utilisateur p = new Utilisateur();
		p = (Utilisateur) query.uniqueResult();
		return p;
	}

	public boolean ajouter(Utilisateur user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		return true;
	}

	public boolean modifier(Utilisateur user) {
		System.out.println("user dao called");
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		System.out.println("user dao finished");
		return true;
	}

	public boolean supprimer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Utilisateur user = (Utilisateur) session.load(Utilisateur.class, new Integer(id));
		if (user != null) {
			session.delete(user);
			return true;
		}
		return false;
	}

	public Utilisateur getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Utilisateur where idUtilisateur= :id");
		query.setParameter("id", id);

		return (Utilisateur) query.uniqueResult();
	}

	public Utilisateur getUserByCin(String cin) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Utilisateur where cin= :cn");
		query.setParameter("cn", cin);

		return (Utilisateur) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> getUsersByFilter(String filter) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Utilisateur where role= :flt order by nom,prenom");
		query.setParameter("flt", filter);

		return query.list();
	}

	public boolean checkField(String field, String value) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Utilisateur where " + field + "  = :fld");
		query.setParameter("fld", value);
		if (null != query.uniqueResult())
			return true;
		return false;
	}

}
