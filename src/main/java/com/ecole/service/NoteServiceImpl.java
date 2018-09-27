package com.ecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecole.beans.Note;
import com.ecole.dao.NoteDAO;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDAO noteDAO;

	@Transactional
	public boolean ajouter(Note note) {
		return noteDAO.ajouter(note);
	}

	@Transactional
	public boolean Modifier(Note note) {
		return noteDAO.Modifier(note);
	}

	@Transactional
	public List<Note> getNoteEleve(int idEleve, int classe) {
		return noteDAO.getNoteEleve(idEleve, classe);
	}

}
