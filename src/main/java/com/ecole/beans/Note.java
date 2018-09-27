package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Note")
public class Note {

	@Id
	@Column(name = "idNote")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int idEleve;

	private int idClasse;

	private int idMatiere;

	private String type;

	private float valeur;

	public Note() {
		super();
	}

	public Note(int id, int idEleve, int idClasse, int idMatiere, String type, float valeur) {
		super();
		this.id = id;
		this.idEleve = idEleve;
		this.idClasse = idClasse;
		this.idMatiere = idMatiere;
		this.type = type;
		this.valeur = valeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public int getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

}
