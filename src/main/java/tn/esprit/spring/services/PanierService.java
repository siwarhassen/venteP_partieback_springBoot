package tn.esprit.spring.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repositories.CommentsRepository;
import tn.esprit.spring.repositories.PanierRepository;
import tn.esprit.spring.repositories.ProduitRepository;
@Service
public class PanierService {
	@Autowired
	PanierRepository pR;
	@Autowired
	ProduitRepository prodR;
	
	public Panier addpanier(Panier p)
	  {
		return pR.save(p);
	  }
	public Panier afficherpanier(Integer userId)
	  {
	    return pR.getpanier(userId);
	  }
	
	public Panier addProducttopanier(Integer prodId,Integer panId)
	{
		Panier p =pR.findById(panId).get();
		Produit pr = prodR.findById(prodId).get();
		Set<Produit> produits  = p.getProduit();
		produits.add(pr);
		p.setProduit(produits);
		return pR.save(p);
	}
	
	public Panier deleteproduitdanspanier(Integer prodId,Integer panId)
	  {
		Panier p =pR.findById(panId).get();
		Produit pr = prodR.findById(prodId).get();
		Set<Produit> produits  =p.getProduit();
		produits.remove(pr);
		p.setProduit(produits);
		return pR.save(p);
	  }
	
	public Produit verifierexistenceproduitdeuuser( Integer userId,Integer produitId  )
	   { Panier p=pR.getpanier(userId);
	   Set<Produit> produits  =  p.getProduit();
	   for(Produit pro:produits)
	   {
		    if(produitId==pro.getId())
		    {
		    	return pro;
		    }
	   }
	    return null;
		
	   }
	
	

		
	
}
