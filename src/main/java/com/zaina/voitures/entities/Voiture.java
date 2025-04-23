package com.zaina.voitures.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


@Entity
public class Voiture {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idVoiture;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String couleur;
	
	@Min(value = 10000)
	@Max(value = 500000)
	private Double prixVoiture ;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date immDate;

	@ManyToOne
	private Marque marque;
	
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



	public Marque getMarque() {
		return marque;
	}



	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
	

}
