package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Produit;


@Repository
public interface ProduitRepository extends CrudRepository< Produit, Integer>{
	@Query("SELECT p FROM Produit p WHERE p.genre= :genre")
	List<Produit> getproductsbygenre(@Param("genre") String genre);
	
	@Query("SELECT p FROM Produit p WHERE p.user.id= :user")
	List<Produit> getproductsofuser(@Param("user") Integer user);
	
	@Query("SELECT p FROM Produit p WHERE p.objets= :objet")
	List<Produit> getProductsByObjet(@Param("objet") String objet);
	
	@Query("SELECT p FROM Produit p WHERE p.marque= :marque")
	List<Produit> getProductsByMarque(@Param("marque") String marque);
	
	@Query("SELECT p FROM Produit p WHERE p.date= :date")
	List<Produit> getProductsbyCurrentDate(@Param("date") String date);
	
	@Query("SELECT p FROM Produit p WHERE p.genre= :genre and  p.objets= :objets")
	List<Produit> getsimilaireProducts(@Param("genre") String genre,@Param("objets") String objets);
	
	@Query("SELECT p  FROM Produit p WHERE p.marque=:marque and p.genre LIKE %:genre% ")
	List<Produit> getProductByCriteriaofMarque(@Param("genre") String genre,@Param("marque") String marque);
	
	@Query("SELECT p  FROM Produit p WHERE p.objets=:objets and p.marque LIKE %:marque% ")
	List<Produit> getProductByCriteriaofObjets(@Param("marque") String marque,@Param("objets") String objets);
}
