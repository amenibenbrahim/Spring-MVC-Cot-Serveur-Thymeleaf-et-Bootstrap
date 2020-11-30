package com.ameni.medicaments.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedicament;
	private String nomMedicament;
	private Double prixMedicament;
	private Date dateVente;
	
	
	public Medicament() {
		super();
	}


	public Long getIdMedicament() {
		return idMedicament;
	}


	public void setIdMedicament(Long idMedicament) {
		this.idMedicament = idMedicament;
	}


	public String getNomMedicament() {
		return nomMedicament;
	}


	public void setNomMedicament(String nomMedicament) {
		this.nomMedicament = nomMedicament;
	}


	public Double getPrixMedicament() {
		return prixMedicament;
	}


	public void setPrixMedicament(Double prixMedicament) {
		this.prixMedicament = prixMedicament;
	}


	public Date getDateVente() {
		return dateVente;
	}


	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}


	public Medicament( String nomMedicament, Double prixMedicament, Date dateVente) {
		super();
		
		this.nomMedicament = nomMedicament;
		this.prixMedicament = prixMedicament;
		this.dateVente = dateVente;
	}


	@Override
	public String toString() {
		return "Medicament [idMedicament=" + idMedicament + ", nomMedicament=" + nomMedicament + ", prixMedicament="
				+ prixMedicament + ", dateVente=" + dateVente + "]";
	}
	
	

}
