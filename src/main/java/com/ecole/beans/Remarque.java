package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Remarque")
public class Remarque {

	@Id
	@Column(name = "idRemarque")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int idProf;
	private int idEleve;
	private String date;
	private String sujet;
	@NotNull(message = "Veuillez entre votre remarque")
	private String texte;
	private int vue_parent;
	private int vue_admin;

	public Remarque() {
		super();
	}

	public Remarque(int id, int idProf, int idEleve, String date, String sujet, String texte, int vue_parent,
			int vue_admin) {
		super();
		this.id = id;
		this.idProf = idProf;
		this.idEleve = idEleve;
		this.date = date;
		this.sujet = sujet;
		this.texte = texte;
		this.vue_parent = vue_parent;
		this.vue_admin = vue_admin;
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

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public int getVue_parent() {
		return vue_parent;
	}

	public void setVue_parent(int vue_parent) {
		this.vue_parent = vue_parent;
	}

	public int getVue_admin() {
		return vue_admin;
	}

	public void setVue_admin(int vue_admin) {
		this.vue_admin = vue_admin;
	}

}
