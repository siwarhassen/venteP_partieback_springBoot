package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produit implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String objets;
	private String description;
	private String genre;
	private String etat;
	private String couleur;
	private float prix;
	private String photo;
	private String date;
	private String marque;
	@JsonBackReference("produit")
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	 private Set<Comments> Comments;
	@ManyToOne
	User  user; //user
	public Produit(String objets, String description, String genre, String etat, String couleur, float prix,
			String photo, String date, String marque, User user) {
		super();
		this.objets = objets;
		this.description = description;
		this.genre = genre;
		this.etat = etat;
		this.couleur = couleur;
		this.prix = prix;
		this.photo = photo;
		this.date = date;
		this.marque = marque;
		this.user = user;
	}
	public Produit() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObjets() {
		return objets;
	}
	public void setObjets(String objets) {
		this.objets = objets;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Produit(int id) {
		super();
		this.id = id;
	}



	
}
