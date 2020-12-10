package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Marque;
import tn.esprit.spring.entities.Objets;
import tn.esprit.spring.repositories.MarqueRepository;
import tn.esprit.spring.repositories.ObjetsRepository;
@Service
public class MarqueService {
	@Autowired
	MarqueRepository mR;
	public List<Marque> getmarque()
	{
		return (List<Marque>) mR.findAll();
	}
	
}
