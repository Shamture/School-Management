package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Contact")
public class Contact {

	@Id
	@Column(name = "idContact")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String sujet;
	@NotNull(message = "Ce champs ne doit pas etre vide")
	private String texte;
	private String date;
	private int vue;

	public Contact() {

	}

	public Contact(int id, String email, String sujet, String texte, String date, int vue) {
		super();
		this.id = id;
		this.email = email;
		this.sujet = sujet;
		this.texte = texte;
		this.date = date;
		this.vue = vue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getVue() {
		return vue;
	}

	public void setVue(int vue) {
		this.vue = vue;
	}

}
