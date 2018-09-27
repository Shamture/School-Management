package com.ecole.data_transfer;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class EleveForm {

	private int idEleve;
	@NotNull(message = "Veuillez entrer le code !")
	private String code_eleve;

	@NotNull(message = "Veuillez entrer le nom !")
	@Size(min = 3, max = 30, message = "Le nom doit contenir entre 3 et 30 caractere !")
	@Pattern(regexp = "[a-z-A-Z ]*", message = "Ce champs contient des caracteres invalides !")
	private String nom_eleve;

	@NotNull(message = "Veuillez entere le prenom !")
	@Size(min = 3, max = 30, message = "Le prenom doit contenir entre 3 et 30 caractere !")
	@Pattern(regexp = "[a-z-A-Z ]*", message = "Ce champs contient des caracteres invalides !")
	private String prenom_eleve;

	@Column(name = "date_naissance")
	@NotNull(message = "Veuillez entrer la data de naissance !")
	private String dateNaissance_eleve;

	private String lieu_naissance_eleve;
	private String date_inscrit_eleve;
	private String email_eleve;

	@NotNull(message = "Veuillez entrer l'adresse !")
	private String adresse_eleve;

	private String num_assurance_eleve;

	private int groupe_eleve;

	private int idParent;
	@NotNull(message = "Veuillez entrer le C.I.N !")
	@Size(min = 8, max = 8, message = "Veuillez entrer un C.I.N valide !")
	@Pattern(regexp = "[0-9]*", message = "Veuillez entrer un C.I.N valide !")
	private String cin_parent;

	@NotNull(message = "Veuillez entrer le nom !")
	@Size(min = 2, max = 30, message = "Le nom doit etre entre 3 et 30 caractere !")
	@Pattern(regexp = "[a-z-A-Z ]*", message = "Ce champs contient des caracteres invalides !")
	private String nom_parent;

	@NotNull(message = "Veuillez entrer le prenom !")
	@Size(min = 2, max = 30, message = "Le prenom doit etre entre 3 et 30 caractere !")
	@Pattern(regexp = "[a-z-A-Z ]*", message = "Ce champs contient des caracteres invalides !")
	private String prenom_parent;

	private String adresse_parent;

	@NotNull(message = "Veuillez entrer l'email !")
	@Email(message = "Veuillez entrer un email valide !")
	private String email_parent;

	@Pattern(regexp = "[0-9 ]*", message = "Veuillez entrer un numero telephone valide !")
	private String tel_parent;

	private String login_parent;

	private String password_parent;

	public EleveForm() {
		super();
	}

	public EleveForm(int idEleve, String code_eleve, String nom_eleve, String prenom_eleve, String dateNaissance_eleve,
			String lieu_naissance_eleve, String date_inscrit_eleve, String email_eleve, String adresse_eleve,
			String num_assurance_eleve, int groupe_eleve, int idParent, String cin_parent, String nom_parent,
			String prenom_parent, String adresse_parent, String email_parent, String tel_parent, String login_parent,
			String password_parent) {
		super();
		this.idEleve = idEleve;
		this.code_eleve = code_eleve;
		this.nom_eleve = nom_eleve;
		this.prenom_eleve = prenom_eleve;
		this.dateNaissance_eleve = dateNaissance_eleve;
		this.lieu_naissance_eleve = lieu_naissance_eleve;
		this.date_inscrit_eleve = date_inscrit_eleve;
		this.email_eleve = email_eleve;
		this.adresse_eleve = adresse_eleve;
		this.num_assurance_eleve = num_assurance_eleve;

		this.groupe_eleve = groupe_eleve;
		this.idParent = idParent;
		this.cin_parent = cin_parent;
		this.nom_parent = nom_parent;
		this.prenom_parent = prenom_parent;
		this.adresse_parent = adresse_parent;
		this.email_parent = email_parent;
		this.tel_parent = tel_parent;
		this.login_parent = login_parent;
		this.password_parent = password_parent;
	}

	public int getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}

	public String getCode_eleve() {
		return code_eleve;
	}

	public void setCode_eleve(String code_eleve) {
		this.code_eleve = code_eleve;
	}

	public String getNom_eleve() {
		return nom_eleve;
	}

	public void setNom_eleve(String nom_eleve) {
		this.nom_eleve = nom_eleve;
	}

	public String getPrenom_eleve() {
		return prenom_eleve;
	}

	public void setPrenom_eleve(String prenom_eleve) {
		this.prenom_eleve = prenom_eleve;
	}

	public String getDateNaissance_eleve() {
		return dateNaissance_eleve;
	}

	public void setDateNaissance_eleve(String dateNaissance_eleve) {
		this.dateNaissance_eleve = dateNaissance_eleve;
	}

	public String getLieu_naissance_eleve() {
		return lieu_naissance_eleve;
	}

	public void setLieu_naissance_eleve(String lieu_naissance_eleve) {
		this.lieu_naissance_eleve = lieu_naissance_eleve;
	}

	public String getDate_inscrit_eleve() {
		return date_inscrit_eleve;
	}

	public void setDate_inscrit_eleve(String date_inscrit_eleve) {
		this.date_inscrit_eleve = date_inscrit_eleve;
	}

	public String getEmail_eleve() {
		return email_eleve;
	}

	public void setEmail_eleve(String email_eleve) {
		this.email_eleve = email_eleve;
	}

	public String getAdresse_eleve() {
		return adresse_eleve;
	}

	public void setAdresse_eleve(String adresse_eleve) {
		this.adresse_eleve = adresse_eleve;
	}

	public String getNum_assurance_eleve() {
		return num_assurance_eleve;
	}

	public void setNum_assurance_eleve(String num_assurance_eleve) {
		this.num_assurance_eleve = num_assurance_eleve;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public String getCin_parent() {
		return cin_parent;
	}

	public void setCin_parent(String cin_parent) {
		this.cin_parent = cin_parent;
	}

	public String getNom_parent() {
		return nom_parent;
	}

	public void setNom_parent(String nom_parent) {
		this.nom_parent = nom_parent;
	}

	public String getPrenom_parent() {
		return prenom_parent;
	}

	public void setPrenom_parent(String prenom_parent) {
		this.prenom_parent = prenom_parent;
	}

	public String getAdresse_parent() {
		return adresse_parent;
	}

	public void setAdresse_parent(String adresse_parent) {
		this.adresse_parent = adresse_parent;
	}

	public String getEmail_parent() {
		return email_parent;
	}

	public void setEmail_parent(String email_parent) {
		this.email_parent = email_parent;
	}

	public String getTel_parent() {
		return tel_parent;
	}

	public void setTel_parent(String tel_parent) {
		this.tel_parent = tel_parent;
	}

	public String getLogin_parent() {
		return login_parent;
	}

	public void setLogin_parent(String login_parent) {
		this.login_parent = login_parent;
	}

	public String getPassword_parent() {
		return password_parent;
	}

	public void setPassword_parent(String password_parent) {
		this.password_parent = password_parent;
	}

	public int getGroupe_eleve() {
		return groupe_eleve;
	}

	public void setGroupe_eleve(int groupe_eleve) {
		this.groupe_eleve = groupe_eleve;
	}

}
