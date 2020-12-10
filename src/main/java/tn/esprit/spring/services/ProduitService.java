package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ProduitRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class ProduitService {
	private static final Logger l = Logger.getLogger(ProduitService.class);
	@Autowired
	ProduitRepository pR;
	
	public Produit addproduct(Produit p)
	{
		return pR.save(p);
	}
	
	public List<Produit> getproductsbygenre(String genre)
	{
		return pR.getproductsbygenre(genre);
	}

	public Optional<Produit> getdetailproduct(Integer id) {
		// TODO Auto-generated method stub
		return pR.findById(id);
	}
	
	public List<Produit> getproductsofuser(Integer id)
	  {
	    return pR.getproductsofuser(id);
	  }
	
	public Produit updateproduct( Produit p)
	  {
	    return pR.save(p);
	  }
	
	public void deleteProduct( Integer id)
	{
		pR.deleteById(id);
	}
	
	public List<Produit> getProductsByObjet(String objet)
	{
		return pR.getProductsByObjet(objet);
	}
	
	public List<Produit> getProductsByMarque(String marque)
	{
		return pR.getProductsByMarque(marque);
	}
	public List<Produit> getProductsbyCurrentDate(String date)
	{
		return pR.getProductsbyCurrentDate(date);
	}
	public List<Produit> getProductByCriteria(String criteria, String val, String condition , String val2) {
		String cri="objets";
		
		if(criteria.equals("genre"))
		{    l.debug(criteria);
			return pR.getProductByCriteriaofMarque(val ,val2);
			
		}
		else 
		{ return pR.getProductByCriteriaofObjets(val, val2);
		  }
	}
	public List<Produit> getsimilaireProducts( String genre, String objets)
	{
		return pR.getsimilaireProducts(genre, objets);
	}
	

	
}
