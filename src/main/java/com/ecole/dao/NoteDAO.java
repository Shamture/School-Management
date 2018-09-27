package com.ecole.dao;

import java.util.List;

import com.ecole.beans.Note;

public interface NoteDAO {

	public boolean ajouter(Note note);

	public boolean Modifier(Note note);

	public List<Note> getNoteEleve(int idEleve, int classe);

}
