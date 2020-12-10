package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(value=Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class User  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private String firstname;
 private String lastname;
 private String email;
 private int phone;
 private String adresse;
 private String ville;
 private String codepostal;
 private String password;
 private String photo;
 @Transient
 private String confirmpassword;
 
 public String getConfirmpassword() {
	return confirmpassword;
}

public void setConfirmpassword(String confirmpassword) {
	this.confirmpassword = confirmpassword;
}
@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
 private Set<Produit> produits;
 
 
 @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
 private Set<Comments> Comments;
public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public String getCodepostal() {
	return codepostal;
}
public void setCodepostal(String codepostal) {
	this.codepostal = codepostal;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public User(String firstname, String lastname, String email, int phone, String adresse, String ville, String codepostal,
		String password, Set<Produit> produits) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.phone = phone;
	this.adresse = adresse;
	this.ville = ville;
	this.codepostal = codepostal;
	this.password = password;
	this.produits = produits;
}
public User() {
	super();
}
public User(int id) {
	super();
	this.id = id;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public User(int id, String firstname, String lastname, String email, int phone, String adresse, String ville,
		String codepostal, String password, String photo, Set<Produit> produits) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.phone = phone;
	this.adresse = adresse;
	this.ville = ville;
	this.codepostal = codepostal;
	this.password = password;
	this.photo = photo;
	this.produits = produits;
}

 
}
