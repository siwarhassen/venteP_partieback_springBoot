package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Objets;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.ObjetsService;
import tn.esprit.spring.services.ProduitService;
@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class ObjetsController {
	@Autowired
	ObjetsService objetservice;
	   // http://localhost:8081/SpringMVC/servlet/getobjets
	 @GetMapping("/getobjets")
	 @ResponseBody
	 public  List<Objets> getobjets() {
	   return objetservice.getobjets();

	 }
}
