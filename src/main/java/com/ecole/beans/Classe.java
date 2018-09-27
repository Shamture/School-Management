package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Classe")
public class Classe {

	@Id
	@Column(name = "idClasse")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClasse;
	private int eleve;
	private int groupe;
	@Column(name = "annee_scolaire")
	private String anneeScolaire;

	public Classe() {

	}

	public Classe(int idClasse, int eleve, int groupe, String anneeScolaire) {
		super();
		this.idClasse = idClasse;
		this.eleve = eleve;
		this.groupe = groupe;
		this.anneeScolaire = anneeScolaire;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public int getEleve() {
		return eleve;
	}

	public void setEleve(int eleve) {
		this.eleve = eleve;
	}

	public int getGroupe() {
		return groupe;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

}
