package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.repositories.CommentsRepository;
@Service
public class CommentsService {

	@Autowired
	CommentsRepository cR;
	
	public Comments addcomment(Comments c)
	{
		return cR.save(c);
	}
	public void deletecomment( Integer id)
	{
		cR.deleteById(id);
	}
	public List<Comments>getcomments(Integer produit)
	{
		return cR.getcomments(produit);
	}
}
