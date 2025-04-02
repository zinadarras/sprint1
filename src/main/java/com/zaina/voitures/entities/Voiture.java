package com.zaina.voitures.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Voiture {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idVoiture;
	private String couleur;
	private Double prixVoiture ;
	private Date immDate;

	
	public Voiture() {
		super();
	}
	
	
	
	public Voiture(String couleur, Double prixVoiture, Date immDate) {
		super();
		this.couleur = couleur;
		this.prixVoiture = prixVoiture;
		this.immDate = immDate;
	}



	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", couleur=" + couleur + ", prixVoiture=" + prixVoiture
				+ ", immDate=" + immDate + "]";
	}




	public Long getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public Double getPrixVoiture() {
		return prixVoiture;
	}
	public void setPrixVoiture(Double prixVoiture) {
		this.prixVoiture = prixVoiture;
	}
	public Date getImmDate() {
		return immDate;
	}
	public void setImmDate(Date immDate) {
		this.immDate = immDate;
	}
	
	

}
