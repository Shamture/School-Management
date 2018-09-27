package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Cahier")
public class Cahier {
	@Id
	@Column(name = "idCahier")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String date;

	private int professeur;

	private int groupe;
	@NotNull(message = "Ce champs ne peut pas être vide !")
	private String description;

	private String exercices;

	public Cahier() {

	}

	public Cahier(int id, String date, int professeur, int groupe, String description, String exercices) {
		super();
		this.id = id;
		this.date = date;
		this.professeur = professeur;
		this.groupe = groupe;
		this.description = description;
		this.exercices = exercices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProfesseur() {
		return professeur;
	}

	public void setProfesseur(int professeur) {
		this.professeur = professeur;
	}

	public int getGroupe() {
		return groupe;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExercices() {
		return exercices;
	}

	public void setExercices(String exercices) {
		this.exercices = exercices;
	}

}
