package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository  extends CrudRepository< User, Integer>{
	 User getUserByEmailAndPassword(String email, String password);
}
