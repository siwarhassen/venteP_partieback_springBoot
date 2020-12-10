package tn.esprit.spring.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.ProduitService;
import tn.esprit.spring.services.UserService;
@CrossOrigin(origins="http://localhost:4200")  
@RestController
public class ProduitController {
	@Autowired
	ProduitService produitservice;
	@Autowired
	ServletContext context;
	  // Ajouter produit: http://localhost:8089/SpringMVC/servlet/addproduct
	/*  @PostMapping("/addproduct")
	  @ResponseBody
	  public Produit addproduct(@RequestBody Produit p) {
	  return produitservice.addproduct(p);
	 
	 }*/
	  
	  // http://localhost:8081/SpringMVC/servlet/getproductsbygenre
		 @GetMapping("/getproductsbygenre")
		 @ResponseBody
		 public  List<Produit> getproductsbygenre(@RequestParam("genre") String genre) {
		   return produitservice.getproductsbygenre(genre);
	
		 }
		 
		 
		  // http://localhost:8081/SpringMVC/servlet/getdetailproduct/{id}
		 @GetMapping("/getdetailproduct/{id}")
		 @ResponseBody
		 public Optional<Produit> getdetailproduct(@PathVariable("id") Integer id) {
		   return produitservice.getdetailproduct(id);
	

		 }
		 
		// http://localhost:8081/SpringMVC/servlet/getproductsofuser
				 @GetMapping("/getproductsofuser")
				 @ResponseBody
				 public  List<Produit> getproductsofuser(@RequestParam("user") Integer user) {
				   return produitservice.getproductsofuser(user);
			
				 }
				 
				   
				   // http://localhost:8089/SpringMVC/servlet/updateproduct
				   @PutMapping("/updateproduct")
				   @ResponseBody
				   public Produit updateproduct(@RequestBody Produit p) {
					  return  produitservice.updateproduct(p);
				   }
				   
				   // http://localhost:8089/SpringMVC/servlet/deleteproduct/{id}
				   @DeleteMapping("/deleteproduct/{id}")
				   @ResponseBody
				   public void deleteproduct(@PathVariable("id") Integer id) {
					    produitservice.deleteProduct(id);
				   }
				   
				   // http://localhost:8081/SpringMVC/servlet/getProductsByObjet
					 @GetMapping("/getProductsByObjet")
					 @ResponseBody
					 public  List<Produit> getProductsByObjet(@RequestParam("objets") String objet) {
					   return produitservice.getProductsByObjet(objet);
				
					 }
					 
					   // http://localhost:8081/SpringMVC/servlet/getProductsByMarque
					 @GetMapping("/getProductsByMarque")
					 @ResponseBody
					 public  List<Produit> getProductsByMarque(@RequestParam("marque") String marque) {
					   return produitservice.getProductsByMarque(marque);
				
					 }
					 
					   // http://localhost:8081/SpringMVC/servlet/getProductsbyCurrentDate
					 @GetMapping("/getProductsbyCurrentDate")
					 @ResponseBody
					 public  List<Produit> getProductsbyCurrentDate(@RequestParam("date") String date) {
					   return produitservice.getProductsbyCurrentDate(date);
				
					 }
					
					   // http://localhost:8081/SpringMVC/servlet/getsimilaireProducts
					 @GetMapping("/getsimilaireProducts")
					 @ResponseBody
					 public  List<Produit> getsimilaireProducts(@RequestParam("genre") String genre,@RequestParam("objets") String objets) {
					   return produitservice.getsimilaireProducts(genre, objets);
				
					 }
					 
					   // http://localhost:8089/SpringMVC/servlet/getProductByCriteria
					 @GetMapping("/getProductByCriteria")
					 @ResponseBody
					 public  List<Produit> getProductByCriteria(@RequestParam("criteria") String criteria,@RequestParam("val") String val,@RequestParam("condition") String condition,@RequestParam("val2") String val2) {
					   return produitservice.getProductByCriteria(criteria, val, condition, val2);
				
					 }
					 
					 
					 
					  
					   @PostMapping("/addprod")
					   public Produit addprod(@RequestParam("image") MultipartFile file ,@RequestParam("produit") String produit) throws IOException
					   {
						   Produit p= new ObjectMapper().readValue(produit, Produit.class);
						  
						   
						   boolean isExist= new File(context.getRealPath("/images")).exists();
						   if(!isExist)
						   {
							   new File(context.getRealPath("/images/")).mkdir();
							   
						   }
						   String filename= file.getOriginalFilename();
						   String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
						   File serverfile=new File(context.getRealPath("/images/" +File.separator +modifiedFileName));
						   try
						   {
							   FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
						   }
						   catch (Exception e)
						   {
							   e.printStackTrace();
						   }
						 
						   p.setPhoto(modifiedFileName);
						   return produitservice.addproduct(p);	   
								   }
					   
					   
					// http://localhost:8089/SpringMVC/servlet/
					   @GetMapping("/getimageofproduct/{id}")
					   @ResponseBody
					   public byte[] getimageofproduit(@PathVariable("id") Integer id) throws IOException {
						  Produit produit= produitservice.getdetailproduct(id).get();
						  return Files.readAllBytes(Paths.get(context.getRealPath("/images/")+produit.getPhoto()));
					   }
}
