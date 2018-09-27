package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Eleve")
public class Eleve {

	@Id
	@Column(name = "idEleve")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEleve;
	@NotNull(message = "Veuillez entere le code !")
	@Column(name = "code_eleve")
	private String code;
	@NotNull(message = "Veuillez entere le nom !")
	@Size(min = 3, max = 30, message = "Le nom doit contenir entre 3 et 30 caractere !")
	@Pattern(regexp = "[a-z-A-Z ]*", message = "Ce champs contient des caracteres invalides !")
	private String nom;
	@NotNull(message = "Veuillez entere le prenom !")
	@Size(min = 3, max = 30, message = "Le prenom doit contenir entre 3 et 30 caractere !")
	@Pattern(regexp = "[a-z-A-Z ]*", message = "Ce champs contient des caracteres invalides !")
	private String prenom;
	@Column(name = "date_naissance")
	@NotNull(message = "Veuillez entrer la data de naissance !")
	private String dateNaissance;

	private String lieu_naissance;
	private String date_inscrit;
	private String email;
	@NotNull(message = "Veuillez entrer l'adresse !")
	private String adresse;
	private String num_assurance;
	private int parent;

	public Eleve() {

	}

	public Eleve(int idEleve, String code, String nom, String prenom, String dateNaissance, String lieu_naissance,
			String date_inscrit, String email, String adresse, String num_assurance, int parent) {
		super();
		this.idEleve = idEleve;
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.lieu_naissance = lieu_naissance;
		this.date_inscrit = date_inscrit;
		this.email = email;
		this.adresse = adresse;
		this.num_assurance = num_assurance;
		this.parent = parent;
	}

	public int getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dataNaissance) {
		this.dateNaissance = dataNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getLieu_naissance() {
		return lieu_naissance;
	}

	public void setLieu_naissance(String lieu_naissance) {
		this.lieu_naissance = lieu_naissance;
	}

	public String getDate_inscrit() {
		return date_inscrit;
	}

	public void setDate_inscrit(String date_inscrit) {
		this.date_inscrit = date_inscrit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNum_assurance() {
		return num_assurance;
	}

	public void setNum_assurance(String num_assurance) {
		this.num_assurance = num_assurance;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
