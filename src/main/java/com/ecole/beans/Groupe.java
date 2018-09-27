package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Groupe")
public class Groupe {

	@Id
	@Column(name = "idGroupe")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Veuillez entrer le niveau du groupe !")
	private int niveau;
	@NotNull(message = "Veuillez entrer le nom de ce groupe !")
	private String nom;

	public Groupe() {

	}

	public Groupe(int id, int niveau, String nom) {
		super();
		this.id = id;
		this.niveau = niveau;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return this.niveau + " Groupe " + this.nom;
	}

}
