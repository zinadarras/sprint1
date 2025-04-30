package com.zaina.voitures.DTO;

import java.util.Date;

import com.zaina.voitures.entities.Marque;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoitureDTO {
	private Long idVoiture;
	private String couleur;
	private Double prixVoiture;
	private Date immDate;
	private Marque marque;
	private String nomMarque;

}
