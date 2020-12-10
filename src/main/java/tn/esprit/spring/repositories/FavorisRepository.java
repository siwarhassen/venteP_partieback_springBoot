package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Favoris;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Produit;

@Repository
public interface FavorisRepository extends CrudRepository< Favoris, Integer>{
	
	@Query("SELECT p FROM Favoris p WHERE p.user.id= :user")
	Favoris getfavoris(@Param("user") Integer user);
	
	@Query("SELECT count(p) FROM Favoris p WHERE p.user.id= :user and p.produit= :produit")
	Produit verifierexistenceproduitdeuuser(@Param("user") Integer user,@Param("produit") Integer produit);
}
