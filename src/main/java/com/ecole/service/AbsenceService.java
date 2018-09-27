package com.ecole.service;

import java.util.List;

import com.ecole.beans.Absence;

public interface AbsenceService {

	public boolean ajouter(Absence abs);

	public boolean modifier(Absence absence);

	public boolean setVue(Absence abs);

	public List<Absence> getAbsenceNonVue(int idEleve);

	public List<Absence> getAllAbsence(int idEleve);
}
