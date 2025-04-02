package com.zaina.voitures;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zaina.voitures.entities.Voiture;
import com.zaina.voitures.service.VoitureService;

@SpringBootApplication
public class VoituresApplication implements CommandLineRunner{

	@Autowired
	VoitureService voitureService;
	
	public static void main(String[] args) {
		SpringApplication.run(VoituresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		voitureService.saveVoiture(new Voiture("Blanc",70000.0,new Date()));	
		voitureService.saveVoiture(new Voiture("Rouge",150000.0,new Date()));		
		voitureService.saveVoiture(new Voiture("Gris",100000.0,new Date()));		

	}

}
