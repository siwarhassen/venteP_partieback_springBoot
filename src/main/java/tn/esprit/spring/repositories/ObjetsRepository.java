package tn.esprit.spring.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Objets;
import tn.esprit.spring.entities.Produit;
@Repository
public interface ObjetsRepository extends CrudRepository< Objets, Integer>{

}
