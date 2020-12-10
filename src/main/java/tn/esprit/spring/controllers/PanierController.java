package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Comments;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.CommentsService;
import tn.esprit.spring.services.PanierService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class PanierController {
	@Autowired
	PanierService panierservice;
	
	  // Ajouter panier: http://localhost:8089/SpringMVC/servlet/addpanier
	  @PostMapping("/addpanier")
	  @ResponseBody
	  public Panier addpanier(@RequestBody Panier p) {
	  return panierservice.addpanier(p);
	 
	 }
	  
	// http://localhost:8081/SpringMVC/servlet/Affecter-Employe-Departement/{Departement-id}/{Employer-id}
		@PutMapping("/addproducttopanier/{prodId}/{panId}")
		@ResponseBody
		public Panier addproducttopanier(@PathVariable("prodId") Integer prodId,
				@PathVariable("panId") Integer panId) {
			return panierservice.addProducttopanier(prodId, panId);
		}
		
		  // http://localhost:8081/SpringMVC/servlet/getpanier
		 @GetMapping("/getpanier")
		 @ResponseBody
		 public  Panier getpanier(@RequestParam("user") Integer user) {
		   return panierservice.afficherpanier(user);
	
		 }
		
		 // http://localhost:8089/SpringMVC/servlet/deletecomment/{id}
		   @DeleteMapping("/deleteproduitdanspanier/{prodId}/{panId}")
		   @ResponseBody
		   public Panier deleteproduitdanspanier(@PathVariable("prodId") Integer prodId,@PathVariable("panId") Integer panId) {
			  return panierservice.deleteproduitdanspanier(prodId, panId);
		   }
		   
		   // http://localhost:8081/SpringMVC/servlet/verifierexistenceproduitdeuuser
			 @GetMapping("/verifierexistenceproduitdeuuser")
			 @ResponseBody
			 public  Produit verifierexistenceproduitdeuuser(@RequestParam("userId") Integer userId,@RequestParam("produitId") Integer produitId) {
			   return panierservice.verifierexistenceproduitdeuuser(userId, produitId);
		
			 }
		  
}
