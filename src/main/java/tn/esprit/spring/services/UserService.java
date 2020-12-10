package tn.esprit.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository uR;
	
	public User register(User u)
	{
		return uR.save(u);
	}
	
	public Optional<User> getuser(Integer id)
	{
		return uR.findById(id);
	}
	
	public User login(String email ,String password)
	{
		return uR.getUserByEmailAndPassword(email, password);
	}
	
	public User updateuser( User u)
	{
		return uR.save(u);
	}
	

}
