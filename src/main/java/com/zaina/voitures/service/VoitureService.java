package com.zaina.voitures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zaina.voitures.DTO.VoitureDTO;
import com.zaina.voitures.entities.Marque;
import com.zaina.voitures.entities.Voiture;

public interface VoitureService {
	
	VoitureDTO saveVoiture(VoitureDTO v);
	VoitureDTO getVoiture(Long id);
	List<VoitureDTO> getAllVoitures();
	
	VoitureDTO updateVoiture(VoitureDTO v);
	void deleteVoiture(Voiture v);
	void deleteVoitureById(Long id);
	
	
	Page<Voiture> getAllVoituresParPage(int page, int size);
	
	List<Voiture> findByCouleur(String couleur);
	List<Voiture> findByCouleurContains(String couleur);
	List<Voiture> findByCouleurPrix (String couleur, Double prix);
	List<Voiture> findByMarque (Marque marque);
	List<Voiture> findByMarqueIdMar(Long id);
	List<Voiture> findByOrderByCouleurAsc();
	List<Voiture> trierVoitures();
	List <Marque> getAllMarques();
	

	VoitureDTO convertEntityToDTO(Voiture v);
	Voiture convertDTOToEntity(VoitureDTO voitureDTO);

}
