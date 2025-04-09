package com.zaina.voitures.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="couleurVoit", types= {Voiture.class})
public interface VoitureProjection {
	public String getCouleur();
}
