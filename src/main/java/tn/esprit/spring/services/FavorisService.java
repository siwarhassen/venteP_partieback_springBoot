package tn.esprit.spring.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Favoris;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repositories.FavorisRepository;
import tn.esprit.spring.repositories.PanierRepository;
import tn.esprit.spring.repositories.ProduitRepository;

@Service
public class FavorisService {
	@Autowired
	FavorisRepository pR;
	@Autowired
	ProduitRepository prodR;
	
	public Favoris addfavoris(Favoris f)
	  {
		return pR.save(f);
	  }
	public Favoris afficherfavoris(Integer userId)
	  {
	    return pR.getfavoris(userId);
	  }
	
	public Favoris addProducttofavoris(Integer prodId,Integer panId)
	{
		Favoris p =pR.findById(panId).get();
		Produit pr = prodR.findById(prodId).get();
		Set<Produit> produits  = p.getProduit();
		produits.add(pr);
		p.setProduit(produits);
		return pR.save(p);
	}
	
	public Favoris deleteproduitdansfavoris(Integer prodId,Integer panId)
	  {
		Favoris p =pR.findById(panId).get();
		Produit pr = prodR.findById(prodId).get();
		Set<Produit> produits  =p.getProduit();
		produits.remove(pr);
		p.setProduit(produits);
		return pR.save(p);
	  }
	
	public Produit verifierexistenceproduitdeuuser( Integer userId,Integer produitId  )
	   { Favoris p=pR.getfavoris(userId);
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
