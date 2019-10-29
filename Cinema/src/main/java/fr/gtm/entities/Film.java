package fr.gtm.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "films")
@Access(AccessType.FIELD)
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_film")
	private long id;
	@Column(name="titre")
	private String Titre;
	@Column(name="realisateur")
	private String realisateur;
	@Column(name="date_sortie")
	private LocalDate date_sortie;
	@Column(name="duree")
	private int duree;
	
	private Map<String, Acteur> roles = new HashMap<String, Acteur>();
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public LocalDate getDate_sortie() {
		return date_sortie;
	}
	public void setDate_sortie(LocalDate date_sortie) {
		this.date_sortie = date_sortie;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Map<String, Acteur> getRoles() {
		return roles;
	}
	public void setRoles(Map<String, Acteur> roles) {
		this.roles = roles;
	}
	
	
	
}
