package com.ecole.data_transfer;

public class AbsenceTransfer {

	private String date;
	private String professeur;
	private String eleve;
	private String matiere;
	private byte vue;

	public AbsenceTransfer() {
		super();
	}

	public AbsenceTransfer(String date, String professeur, String eleve, String matiere, byte vue) {
		super();
		this.date = date;
		this.professeur = professeur;
		this.eleve = eleve;
		this.matiere = matiere;
		this.vue = vue;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProfesseur() {
		return professeur;
	}

	public void setProfesseur(String professeur) {
		this.professeur = professeur;
	}

	public String getEleve() {
		return eleve;
	}

	public void setEleve(String eleve) {
		this.eleve = eleve;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public byte getVue() {
		return vue;
	}

	public void setVue(byte vue) {
		this.vue = vue;
	}

}
