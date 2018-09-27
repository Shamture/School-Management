package com.ecole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean ajouter(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(contact);
		return true;
	}

	public boolean modifier(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.update(contact);
		return true;
	}

	public Contact getContact(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Contact where idContact= :idc");
		query.setParameter("idc", id);
		return (Contact) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getNouveauContact() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Contact where vue=0 order by date desc");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getAllContact() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Contact");
		return query.list();
	}

}
