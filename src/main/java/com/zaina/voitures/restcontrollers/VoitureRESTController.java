package com.zaina.voitures.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zaina.voitures.DTO.VoitureDTO;
import com.zaina.voitures.entities.Voiture;
import com.zaina.voitures.service.VoitureService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoitureRESTController {

	@Autowired
	VoitureService voitureService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<VoitureDTO> getAllVoitures(){
		return voitureService.getAllVoitures();		
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public VoitureDTO getVoitureById(@PathVariable("id") Long id) {
		return voitureService.getVoiture(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public VoitureDTO createVoiture(@RequestBody VoitureDTO voiture) {
		return voitureService.saveVoiture(voiture);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public VoitureDTO updateVoiture(@RequestBody VoitureDTO voiture) {
		return voitureService.updateVoiture(voiture);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteVoiture(@PathVariable("id") Long id) {
		 voitureService.deleteVoitureById(id);
	}
	@RequestMapping(value="/voitsmarque/{idMarque}",method = RequestMethod.GET)
	public List<Voiture> getProduitsByMarqueId(@PathVariable("idMarque") Long idMarque) {
	return voitureService.findByMarqueIdMar(idMarque);
	}

	
}
