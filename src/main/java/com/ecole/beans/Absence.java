package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Absence")
public class Absence {

	@Id
	@Column(name = "idAbsence")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int idProf;
	private int idEleve;

	@NotNull(message = "Veuillez entrer la date d'absence !")
	private String date;
	@NotNull(message = "Veuillez chosir la matiere !")
	private int matiere;

	private int vue;

	public Absence() {

	}

	public Absence(int id, int idProf, int idEleve, String date, int matiere, int vue) {
		super();
		this.id = id;
		this.idProf = idProf;
		this.idEleve = idEleve;
		this.date = date;
		this.matiere = matiere;
		this.vue = vue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProf() {
		return idProf;
	}

	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}

	public int getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMatiere() {
		return matiere;
	}

	public void setMatiere(int matiere) {
		this.matiere = matiere;
	}

	public int getVue() {
		return vue;
	}

	public void setVue(int vue) {
		this.vue = vue;
	}

}
