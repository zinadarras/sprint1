package com.zaina.voitures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.zaina.voitures.entities.Marque;
import com.zaina.voitures.entities.Voiture;
import com.zaina.voitures.repos.VoitureRepository;
import com.zaina.voitures.service.VoitureService;

@SpringBootTest
class VoituresApplicationTests {

	@Autowired
	private VoitureRepository voitureRepository;
	
	@Autowired
	private VoitureService voitureService;
	
	@Test
	public void testCreateVoiture() {
	Voiture voit = new Voiture("Noir",300000.0,new Date());
	voitureRepository.save(voit);
	}
	@Test
	public void testFindVoiture()
	{
	Voiture v = voitureRepository.findById(3L).get();
	System.out.println(v);
	}
	@Test
	public void testUpdateVoiture()
	{
	Voiture v = voitureRepository.findById(2L).get();
	v.setPrixVoiture(40000.0);
	voitureRepository.save(v);
	}
	@Test
	public void testDeleteVoiture()
	{
	voitureRepository.deleteById(1L);
	}
	@Test
	public void testListerTousProduits(){
	List<Voiture> voits = voitureRepository.findAll();
	for (Voiture v : voits)
	{
	System.out.println(v);
	}
	}
	
	 @Test
	 public void testFindByNomVoitureContains()
	 {
	 Page<Voiture> voits = voitureService.getAllVoituresParPage(0,2);
	 System.out.println(voits.getSize());
	 System.out.println(voits.getTotalElements());
	 System.out.println(voits.getTotalPages());
	 voits.getContent().forEach(v -> {System.out.println(v.toString());
	  });
	 }

	 @Test
		public void testFindByCouleur()
		{
		List<Voiture> voits = voitureRepository.findByCouleur("Rouge");
		for (Voiture v : voits)
		{
		System.out.println(v);
		}
		}
	 
	 @Test
		public void testFindByCouleurContains()
		{
		List<Voiture> voits = voitureRepository.findByCouleurContains("Gr");
		for (Voiture v : voits)
		{
		System.out.println(v);
		}
		}
	 
	 @Test
		public void testFindByCoulPrix()
		{
		List<Voiture> voits = voitureRepository.findByCoulPrix("Gris",30000.0);
		for (Voiture v : voits)
		{
		System.out.println(v);
		}
		}
	 
	 @Test
		public void testFindByMarque()
		{
		 Marque mar=new Marque();
		 mar.setIdMarque(1L);
		List<Voiture> voits = voitureRepository.findByMarque(mar);
		for (Voiture v : voits)
		{
		System.out.println(v);
		}
		}
	
	 @Test
		public void testFindByMarqueIdMarque()
		{
		List<Voiture> voits = voitureRepository.findByMarqueIdMarque(1L);
		for (Voiture v : voits)
		{
		System.out.println(v);
		}
		}
	 
	 @Test
		public void testfindByOrderByCouleurAsc()
		{
		List<Voiture> voits = voitureRepository.findByOrderByCouleurAsc();
		for (Voiture v : voits)
		{
		System.out.println(v);
		}
		}
	 
	 @Test
		public void testTrierVoiture()
		{
		List<Voiture> voits = voitureRepository.trierVoitures();
		for (Voiture v : voits)
		{
		System.out.println(v);
		}
		}
	 
	
	 
	}
