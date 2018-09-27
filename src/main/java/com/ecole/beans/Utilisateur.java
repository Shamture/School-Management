package com.ecole.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

	@Id
	@Column(name = "idUtilisateur")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Veuillez entrer le C.I.N !")
	@Size(min = 8, max = 8, message = "Veuillez entrer un C.I.N valide !")
	@Pattern(regexp = "[0-9]*", message = "Veuillez entrer un C.I.N valide !")
	private String cin;
	@NotNull(message = "Veuillez entrer le nom !")
	@Size(min = 2, max = 30, message = "Le nom doit etre entre 3 et 30 caractere !")
	@Pattern(regexp = "[a-z-A-Z ]*", message = "Ce champs contient des caracteres invalides !")
	private String nom;
	@NotNull(message = "Veuillez entrer le prenom !")
	@Size(min = 2, max = 30, message = "Le prenom doit etre entre 3 et 30 caractere !")
	@Pattern(regexp = "[a-z-A-Z ]*", message = "Ce champs contient des caracteres invalides !")
	private String prenom;

	private String adresse;

	@NotNull(message = "Veuillez entrer l'email !")
	@Email(message = "Veuillez entrer un email valide !")
	private String email;
	@Pattern(regexp = "[0-9]*", message = "Veuillez entrer un numero telephone valide !")
	private String tel;
	@NotNull(message = "Veuillez entrer le login !")
	@Size(min = 2, max = 30, message = "Le login doit etre entre 4 et 30 caractere !")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Ce champs contient des caracteres invalides !")
	private String login;
	@NotNull(message = "Veuillez entrer le mot de passe !")
	@Size(min = 6, max = 30, message = "Le mot de passe doit etre entre 6 et 30 caractere !")
	private String password;

	private String identifiant_uniq;
	private String role;

	@Transient
	private MultipartFile image;

	public Utilisateur() {

	}

	public Utilisateur(int id, String cin, String nom, String prenom, String adresse, String email, String tel,
			String login, String password, String identifiant_uniq, String role, MultipartFile image) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.login = login;
		this.password = password;
		this.identifiant_uniq = identifiant_uniq;
		this.role = role;

		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdentifiant_uniq() {
		return identifiant_uniq;
	}

	public void setIdentifiant_uniq(String identifiant_uniq) {
		this.identifiant_uniq = identifiant_uniq;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
