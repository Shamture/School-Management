package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Seance")
public class Seance {

	@Id
	@Column(name = "idSeance")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSeance;

	private int classe;

	private int professeur;

	private int matiere;

	private String jour;

	private String debut;

	private String fin;

	public Seance() {

	}

	public Seance(int idSeance, int classe, int professeur, int matiere, String jour, String debut, String fin) {
		super();
		this.idSeance = idSeance;
		this.classe = classe;
		this.professeur = professeur;
		this.matiere = matiere;
		this.jour = jour;
		this.debut = debut;
		this.fin = fin;
	}

	public int getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public int getProfesseur() {
		return professeur;
	}

	public void setProfesseur(int professeur) {
		this.professeur = professeur;
	}

	public int getMatiere() {
		return matiere;
	}

	public void setMatiere(int matiere) {
		this.matiere = matiere;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

}
