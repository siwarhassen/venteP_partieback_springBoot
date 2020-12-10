package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Objets;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repositories.ObjetsRepository;

@Service
public class ObjetsService {
	@Autowired
	ObjetsRepository oR;
	public List<Objets> getobjets()
	{
		return (List<Objets>) oR.findAll();
	}
}
