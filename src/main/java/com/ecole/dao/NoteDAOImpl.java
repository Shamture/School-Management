package com.ecole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecole.beans.Note;

@Repository
public class NoteDAOImpl implements NoteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean ajouter(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(note);
		return true;
	}

	public boolean Modifier(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.update(note);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Note> getNoteEleve(int idEleve, int classe) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Note where idEleve = :ide and idClasse = :cls");
		query.setParameter("ide", idEleve);
		query.setParameter("cls", classe);
		return query.list();
	}

}
