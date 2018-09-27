package com.ecole.data_transfer;

public class RemarqueTransfer {

	private int id;
	private String sujet;
	private String remarque;
	private String eleve;
	private String professeur;
	private String date;
	private int vue;

	public RemarqueTransfer() {
		super();
	}

	public RemarqueTransfer(int id, String sujet, String remarque, String eleve, String professeur, String date,
			int vue) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.remarque = remarque;
		this.eleve = eleve;
		this.professeur = professeur;
		this.date = date;
		this.vue = vue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public String getEleve() {
		return eleve;
	}

	public void setEleve(String eleve) {
		this.eleve = eleve;
	}

	public String getProfesseur() {
		return professeur;
	}

	public void setProfesseur(String professeur) {
		this.professeur = professeur;
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
