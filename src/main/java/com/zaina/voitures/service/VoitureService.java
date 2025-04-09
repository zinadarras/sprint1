package com.zaina.voitures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zaina.voitures.entities.Marque;
import com.zaina.voitures.entities.Voiture;

public interface VoitureService {
	Voiture saveVoiture(Voiture v);
	Voiture updateVoiture(Voiture v);
	void deleteVoiture(Voiture v);
	void deleteVoitureById(Long id);
	Voiture getVoiture(Long id);
	List<Voiture> getAllVoitures();
	
	Page<Voiture> getAllVoituresParPage(int page, int size);
	
	List<Voiture> findByCouleur(String couleur);
	List<Voiture> findByCouleurContains(String couleur);
	List<Voiture> findByCouleurPrix (String couleur, Double prix);
	List<Voiture> findByMarque (Marque marque);
	List<Voiture> findByMarqueIdMar(Long id);
	List<Voiture> findByOrderByCouleurAsc();
	List<Voiture> trierVoitures();


}
