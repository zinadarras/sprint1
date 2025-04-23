package com.zaina.voitures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zaina.voitures.entities.Marque;
import com.zaina.voitures.entities.Voiture;
import com.zaina.voitures.repos.MarqueRepository;
import com.zaina.voitures.repos.VoitureRepository;


@Service
public class VoitureServiceImpl implements VoitureService{

	@Autowired
	VoitureRepository voitureRepository;
	
	@Autowired
	MarqueRepository marqueRepository;
	
	@Override
	public Voiture saveVoiture(Voiture v) {
		return voitureRepository.save(v);
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		return voitureRepository.save(v);
	}

	@Override
	public void deleteVoiture(Voiture v) {
		voitureRepository.delete(v);
		
	}

	@Override
	public void deleteVoitureById(Long id) {
		voitureRepository.deleteById(id);	
	}

	@Override
	public Voiture getVoiture(Long id) {
		return voitureRepository.findById(id).get();
	}

	@Override
	public List<Voiture> getAllVoitures() {
		return voitureRepository.findAll();
	}

	@Override
	public Page<Voiture> getAllVoituresParPage(int page, int size) {
		return voitureRepository.findAll(PageRequest.of(page, size));

	}

	@Override
	public List<Voiture> findByCouleur(String couleur) {
		return voitureRepository.findByCouleur(couleur);
	}

	@Override
	public List<Voiture> findByCouleurContains(String couleur) {
		return voitureRepository.findByCouleurContains(couleur);
	}

	@Override
	public List<Voiture> findByCouleurPrix(String couleur, Double prix) {
		return voitureRepository.findByCoulPrix(couleur, prix);
	}

	@Override
	public List<Voiture> findByMarque(Marque marque) {
		return voitureRepository.findByMarque(marque);
	}

	@Override
	public List<Voiture> findByMarqueIdMar(Long id) {
		return voitureRepository.findByMarqueIdMarque(id);
	}

	@Override
	public List<Voiture> findByOrderByCouleurAsc() {
		return voitureRepository.findByOrderByCouleurAsc();
	}

	@Override
	public List<Voiture> trierVoitures() {
		return voitureRepository.trierVoitures();
	}
	
	@Override
	public List<Marque> getAllMarques() {
		return marqueRepository.findAll();
	}
	

}
