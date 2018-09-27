package com.ecole.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Classe;
import com.ecole.beans.Eleve;

@Repository
public class EleveDAOIml implements EleveDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean ajouter(Eleve eleve) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(eleve);
		return true;
	}

	public Eleve getEleve(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Eleve where idEleve= :id");
		query.setParameter("id", id);
		return (Eleve) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Eleve> getElevePourParent(int idParent) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Eleve where parent = :idP");
		query.setParameter("idP", idParent);
		List<Eleve> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Eleve> getTousEleve() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Eleve order by date_inscrit desc");

		List<Eleve> list = query.list();
		return list;
	}

	public boolean deleteEleve(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Eleve eleve = (Eleve) session.load(Eleve.class, new Integer(id));
		if (null != eleve) {
			session.delete(eleve);
			return true;
		}
		return false;
	}

	public Eleve getEleveByCode(String code) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Eleve where code_eleve= :cd");
		query.setParameter("cd", code);
		return (Eleve) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Eleve> getListElevePourClasse(int idGroupe, String anneeUniversitaire) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Classe where groupe= :idG and annee_scolaire = :ans");
		query.setParameter("idG", idGroupe);
		query.setParameter("ans", anneeUniversitaire);
		List<Classe> listClasse = query.list();
		List<Eleve> listEleve = new ArrayList<Eleve>();
		for (Classe cl : listClasse) {
			int idEleve = cl.getEleve();
			Eleve eleve = getEleve(idEleve);
			listEleve.add(eleve);
		}
		return listEleve;
	}

	public boolean modifier(Eleve eleve) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(eleve);
		return true;
	}

}
