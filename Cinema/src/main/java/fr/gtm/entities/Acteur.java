package fr.gtm.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "acteurs")
@Access(AccessType.FIELD)
@NamedQuery(name = "Acteurs.All",query = "SELECT a FROM Acteur a")
public class Acteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_acteur")
	private long id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="date_naissance")
	private LocalDate date_naissance;
	@Column(name="date_deces")
	private LocalDate date_deces;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="films_acteur",
	joinColumns=@JoinColumn(name="fk_acteur", referencedColumnName="pk_acteur"),
	inverseJoinColumns=@JoinColumn(name="fk_film", referencedColumnName="pk_film"))
	@MapKeyColumn(name="role")
	private Map<String, Film> roles = new HashMap<String, Film>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="films_acteur",
	joinColumns=@JoinColumn(name="fk_acteur", referencedColumnName="pk_acteur"),
	inverseJoinColumns=@JoinColumn(name="fk_film", referencedColumnName="pk_film"))
	private Map<Role, Film> role = new HashMap<Role, Film>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}

	public LocalDate getDate_deces() {
		return date_deces;
	}

	public void setDate_deces(LocalDate date_deces) {
		this.date_deces = date_deces;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Map<String, Film> getRoles() {
		return roles;
	}

	public void setRoles(Map<String, Film> roles) {
		this.roles = roles;
	}

	public Map<Role, Film> getRole() {
		return role;
	}

	public void setRole(Map<Role, Film> role) {
		this.role = role;
	}
	
	
}
