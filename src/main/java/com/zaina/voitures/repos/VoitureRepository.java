package com.zaina.voitures.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zaina.voitures.entities.Marque;
import com.zaina.voitures.entities.Voiture;

@RepositoryRestResource(path = "rest")
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

	List <Voiture> findByCouleur(String couleur);
	List <Voiture> findByCouleurContains(String couleur);
	
	/*@Query("select v from Voiture v where v.couleur like %?1 and v.prixVoiture > ?2")
	List<Voiture> findByCoulPrix (String couleur, Double prix);*/
	
	@Query("select v from Voiture v where v.couleur like %:couleur and v.prixVoiture > :prix")
	List<Voiture> findByCoulPrix (@Param("couleur") String couleur, @Param("prix") Double prix);

	@Query("select v from Voiture v where v.marque =?1")
	List<Voiture> findByMarque (Marque marque);
	
	List<Voiture> findByMarqueIdMarque (Long id);
	
	
	List<Voiture> findByOrderByCouleurAsc();
	
	@Query("select v from Voiture v order by v.couleur ASC, v.prixVoiture DESC")
	List<Voiture> trierVoitures();
}
