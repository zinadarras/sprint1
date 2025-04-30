package com.zaina.voitures.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaina.voitures.DTO.VoitureDTO;
import com.zaina.voitures.entities.Marque;
import com.zaina.voitures.entities.Voiture;
import com.zaina.voitures.repos.MarqueRepository;
import com.zaina.voitures.repos.VoitureRepository;

@Transactional
@Service
public class VoitureServiceImpl implements VoitureService{

	@Autowired
	VoitureRepository voitureRepository;
	
	@Autowired
	MarqueRepository marqueRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public VoitureDTO saveVoiture(VoitureDTO v) {
		return convertEntityToDTO( voitureRepository.save(convertDTOToEntity(v)));
	}

	@Override
	public VoitureDTO updateVoiture(VoitureDTO v) {
		return convertEntityToDTO(voitureRepository.save(convertDTOToEntity(v)));
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
	public VoitureDTO getVoiture(Long id) {
		return convertEntityToDTO(voitureRepository.findById(id).get());
	}

	@Override
	public List<VoitureDTO> getAllVoitures() {
		return voitureRepository.findAll().stream()
				.map(this::convertEntityToDTO)
				.collect(Collectors.toList());
		
		//OU BIEN
		/*List<Produit> prods = produitRepository.findAll();
		List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
		for (Produit p : prods)
		listprodDto.add(convertEntityToDto(p));
		return listprodDto;*/

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
	
	@Override
	public VoitureDTO convertEntityToDTO(Voiture v) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		VoitureDTO voitureDTO = modelMapper.map(v, VoitureDTO.class);
		return voitureDTO;
		

		
		/*VoitureDTO voitureDTO = new VoitureDTO();
		voitureDTO.setIdVoiture(v.getIdVoiture());
		voitureDTO.setCouleur(v.getCouleur());
		voitureDTO.setPrixVoiture(v.getPrixVoiture());
		voitureDTO.setMarque(v.getMarque());
		return voitureDTO;*/
		
		/*return VoitureDTO.builder()
				.idVoiture(v.getIdVoiture())
				.couleur(v.getCouleur())
				.prixVoiture(v.getPrixVoiture())
				.marque(v.getMarque())
				.immDate(v.getImmDate())
				.build();*/
		
	}
	@Override
	public Voiture convertDTOToEntity(VoitureDTO voitureDto) {
		Voiture voiture = new Voiture();
		voiture = modelMapper.map(voitureDto, Voiture.class);
		return voiture;
		/*Voiture voiture = new Voiture();
		voiture.setIdVoiture(voitureDto.getIdVoiture());
		voiture.setCouleur(voitureDto.getCouleur());
		voiture.setMarque(voitureDto.getMarque());
		voiture.setImmDate(voitureDto.getImmDate());
		voiture.setPrixVoiture(voitureDto.getPrixVoiture());
	
		return voiture;*/
		}
}
