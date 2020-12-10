package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.CommentsService;
import tn.esprit.spring.services.ProduitService;
@CrossOrigin(origins="http://localhost:4200")  
@RestController
public class CommentsController {
	@Autowired
	CommentsService commentsservice;
	  // Ajouter produit: http://localhost:8089/SpringMVC/servlet/addproduct
	  @PostMapping("/addcomment")
	  @ResponseBody
	  public Comments addcomment(@RequestBody Comments c) {
	  return commentsservice.addcomment(c);
	 
	 }
	  
	  // http://localhost:8081/SpringMVC/servlet/getcomments
		 @GetMapping("/getcomments")
		 @ResponseBody
		 public  List<Comments> getproductsbygenre(@RequestParam("produit") Integer produit) {
		   return commentsservice.getcomments(produit);
	
		 }
		 
		  // http://localhost:8089/SpringMVC/servlet/deletecomment/{id}
		   @DeleteMapping("/deletecomment/{id}")
		   @ResponseBody
		   public void deletecomment(@PathVariable("id") Integer id) {
			   commentsservice.deletecomment(id);
		   }
}
