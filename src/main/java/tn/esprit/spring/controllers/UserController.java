package tn.esprit.spring.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.exception.ResourceNotFoundException;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.UserService;


@CrossOrigin(origins="http://localhost:4200")  
@RestController
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	ServletContext context;
	
	  // Ajouter user: http://localhost:8089/SpringMVC/servlet/register
	  @PostMapping("/register")
	  @ResponseBody
	  public User register(@RequestBody User u) {
	  return userservice.register(u);
	 
	 }
	  
	  // http://localhost:8081/SpringMVC/servlet/getuser/{id}
		 @GetMapping("/getuser/{id}")
		 @ResponseBody
		 public Optional<User> getUser(@PathVariable("id") Integer id) {
		   return userservice.getuser(id);
	

		 }
		 
		// http://localhost:8089/SpringMVC/servlet/login/{email}/{password}
		   @GetMapping("/login")
		   @ResponseBody
		   public User login(@RequestParam("email") String email,@RequestParam("password") String password) {
			  return userservice.login(email, password);
		   }
		   


		   // http://localhost:8089/SpringMVC/servlet/updateuser
		   @PutMapping("/updateuser")
		   @ResponseBody
		   public User updateuser(@RequestBody User u) {
			  return  userservice.updateuser(u);
		   }
		   
		   @PostMapping("/registration")
		   public User Registration(@RequestParam("image") MultipartFile file ,@RequestParam("user") String user) throws IOException
		   {
			   User u= new ObjectMapper().readValue(user, User.class);
			  
			   
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
			 
			   u.setPhoto(modifiedFileName);
			   return userservice.register(u);	   
					   }
		   
		   
		// http://localhost:8089/SpringMVC/servlet/
		   @GetMapping("/getimageofuser/{id}")
		   @ResponseBody
		   public byte[] getimageofuser(@PathVariable("id") Integer id) throws IOException {
			  User user= userservice.getuser(id).get();
			  return Files.readAllBytes(Paths.get(context.getRealPath("/images/")+user.getPhoto()));
		   }
}
