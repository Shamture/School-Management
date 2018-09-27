package com.ecole.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Groupe;

@Repository
public class GroupeDAOImpl implements GroupeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean ajouter(Groupe g) {

		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Groupe> getGroupList() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Groupe> groupsList = session.createQuery("from Groupe order by niveau,nom").list();

		return groupsList;
	}

}
