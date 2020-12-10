package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Marque;
import tn.esprit.spring.entities.Produit;

@Repository
public interface CommentsRepository extends CrudRepository< Comments, Integer>{
	@Query("SELECT c FROM Comments c WHERE c.produit.id= :produit")
	List<Comments> getcomments(@Param("produit") Integer produit);
}
