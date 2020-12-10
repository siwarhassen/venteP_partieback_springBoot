package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Marque;
import tn.esprit.spring.entities.Objets;

@Repository
public interface MarqueRepository  extends CrudRepository< Marque, Integer>{

}
