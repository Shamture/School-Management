package com.ecole.service;

import java.util.List;

import com.ecole.beans.Note;

public interface NoteService {

	public boolean ajouter(Note note);

	public boolean Modifier(Note note);

	public List<Note> getNoteEleve(int idEleve, int classe);
}
