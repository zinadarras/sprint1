package com.zaina.voitures;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.zaina.voitures.entities.Voiture;
import com.zaina.voitures.service.VoitureService;

@SpringBootApplication
public class VoituresApplication implements CommandLineRunner{

	@Autowired
	VoitureService voitureService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(VoituresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		repositoryRestConfiguration.exposeIdsFor(Voiture.class);


	}

}
