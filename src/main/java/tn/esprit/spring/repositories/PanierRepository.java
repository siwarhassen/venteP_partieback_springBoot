package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Produit;

@Repository
public interface PanierRepository extends CrudRepository< Panier, Integer>{
	
	@Query("SELECT p FROM Panier p WHERE p.user.id= :user")
	Panier getpanier(@Param("user") Integer user);
	
	@Query("SELECT count(p) FROM Panier p WHERE p.user.id= :user and p.produit= :produit")
	Produit verifierexistenceproduitdeuuser(@Param("user") Integer user,@Param("produit") Integer produit);
}
