package com.ecole.dao;

import java.util.List;

import com.ecole.beans.Absence;

public interface AbsenceDAO {

	public boolean ajouter(Absence abs);

	public boolean modifier(Absence absence);

	public List<Absence> getAbsenceNonVue(int idEleve);

	public List<Absence> getAllAbsence(int idEleve);

}
