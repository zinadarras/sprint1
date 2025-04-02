package com.zaina.voitures.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaina.voitures.entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
