package com.zaina.voitures.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zaina.voitures.entities.Marque;
import com.zaina.voitures.entities.Voiture;
import com.zaina.voitures.service.VoitureService;

import jakarta.validation.Valid;

@Controller
public class VoitureController {

	@Autowired
	VoitureService voitureService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}
	
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}

	@RequestMapping("/ListeVoitures")
	public String listeVoitures(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size
		)
	 {
		Page<Voiture> voits = voitureService.getAllVoituresParPage(page, size);
		modelMap.addAttribute("voitures", voits);
		modelMap.addAttribute("pages", new int[voits.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeVoitures";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Marque> mar = voitureService.getAllMarques();
		modelMap.addAttribute("voiture", new Voiture());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("marques", mar);
		return "formVoiture";
	}

	@RequestMapping("/saveVoiture")
	public String saveVoiture(@Valid Voiture voiture , BindingResult bindingResult, @RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		int currentPage;
		boolean isNew=false;
		
		if (bindingResult.hasErrors()) return "formVoiture";
		if(voiture.getIdVoiture()==null)//ajout
			isNew=true;
			
	 voitureService.saveVoiture(voiture);
	 if (isNew)  //ajout 
		 {
		 Page<Voiture> voits = voitureService.getAllVoituresParPage(page,size);
		 currentPage=voits.getTotalPages()-1;
	 }
	 else//modif
		 currentPage=page;
	//return "formVoiture";
	 return ("redirect:/ListeVoitures?page="+currentPage+"&size="+size);
	}

	@RequestMapping("/supprimerVoiture")
	public String supprimerVoiture(@RequestParam("id") Long id, ModelMap modelMap , @RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size) {
		voitureService.deleteVoitureById(id);
		Page<Voiture> voits = voitureService.getAllVoituresParPage(page,size);
				modelMap.addAttribute("voitures", voits);
				modelMap.addAttribute("pages", new int[voits.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);
		return "listeVoitures";
	}

	@RequestMapping("/modifierVoiture")
	public String editerVoiture(@RequestParam("id") Long id, ModelMap modelMap , @RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size) {
		List<Marque> mar = voitureService.getAllMarques();
		Voiture v = voitureService.getVoiture(id);
		modelMap.addAttribute("voiture", v);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("marques", mar);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "formVoiture";
	}

	@RequestMapping("/updateVoiture")
	public String updateVoiture(@ModelAttribute("voiture") Voiture voiture, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		voiture.setImmDate(dateCreation);

		voitureService.updateVoiture(voiture);
		List<Voiture> voits = voitureService.getAllVoitures();
		modelMap.addAttribute("voitures", voits);
		return "listeVoitures";
	}

}
