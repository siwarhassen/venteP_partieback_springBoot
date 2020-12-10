package tn.esprit.spring.controllers;

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

import tn.esprit.spring.entities.Favoris;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.FavorisService;
import tn.esprit.spring.services.PanierService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class FavorisController {
	@Autowired
	FavorisService favorisservice;
	
	  // Ajouter favoris: http://localhost:8089/SpringMVC/servlet/addfavoris
	  @PostMapping("/addfavoris")
	  @ResponseBody
	  public Favoris addfavoris(@RequestBody Favoris f) {
	  return favorisservice.addfavoris(f);
	 
	 }
	  
	// http://localhost:8081/SpringMVC/servlet/addproducttofavoris/{prodId}/{panId}
		@PutMapping("/addproducttofavoris/{prodId}/{panId}")
		@ResponseBody
		public Favoris addproducttofavoris(@PathVariable("prodId") Integer prodId,
				@PathVariable("panId") Integer panId) {
			return favorisservice.addProducttofavoris(prodId, panId);
		}
		
		  // http://localhost:8081/SpringMVC/servlet/getfavoris
		 @GetMapping("/getfavoris")
		 @ResponseBody
		 public  Favoris getfavoris(@RequestParam("user") Integer user) {
		   return favorisservice.afficherfavoris(user);
	
		 }
		
		 // http://localhost:8089/SpringMVC/servlet/deletecomment/{id}
		   @DeleteMapping("/deleteproduitdansfavoris/{prodId}/{panId}")
		   @ResponseBody
		   public Favoris deleteproduitdansfavoris(@PathVariable("prodId") Integer prodId,@PathVariable("panId") Integer panId) {
			  return favorisservice.deleteproduitdansfavoris(prodId, panId);
		   }
		   
		   // http://localhost:8081/SpringMVC/servlet/verifierexistenceproduitdeuuserf
			 @GetMapping("/verifierexistenceproduitdeuuserf")
			 @ResponseBody
			 public  Produit verifierexistenceproduitdeuuser(@RequestParam("userId") Integer userId,@RequestParam("produitId") Integer produitId) {
			   return favorisservice.verifierexistenceproduitdeuuser(userId, produitId);
		
			 }
		  
}
