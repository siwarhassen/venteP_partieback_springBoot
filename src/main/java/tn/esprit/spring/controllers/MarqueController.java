package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Marque;
import tn.esprit.spring.entities.Objets;
import tn.esprit.spring.services.MarqueService;
import tn.esprit.spring.services.ObjetsService;
@CrossOrigin(origins="http://localhost:4200")  
@RestController
public class MarqueController {
	@Autowired
	MarqueService marqueservice;
	   // http://localhost:8089/SpringMVC/servlet/getmarque
	 @GetMapping("/getmarque")
	 @ResponseBody
	 public  List<Marque> getmarque() {
	   return marqueservice.getmarque();

	 }
}
