package fr.gtm.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "films")
@Access(AccessType.FIELD)
@NamedQuery(name = "Film.All",query = "SELECT f FROM Film f")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_film")
	private long id;
	@Column(name="titre")
	private String titre;
	@Column(name="realisateur")
	private String realisateur;
	@Column(name="date_sortie")
	private LocalDate date_sortie;
	@Column(name="duree")
	private int duree;
	
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(name="films_acteur",
//	joinColumns=@JoinColumn(name="fk_film"),
//	inverseJoinColumns=@JoinColumn(name="fk_acteur"))
//	private List<Acteur> distribution = new ArrayList<Acteur>();

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="films_acteur",
	joinColumns=@JoinColumn(name="fk_film", referencedColumnName="pk_film"),
	inverseJoinColumns=@JoinColumn(name="fk_acteur", referencedColumnName="pk_acteur"))
	@MapKeyColumn(name="role")
	private Map<String, Acteur> roles = new HashMap<String, Acteur>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="films_acteur",
	joinColumns=@JoinColumn(name="fk_film", referencedColumnName="pk_film"),
	inverseJoinColumns=@JoinColumn(name="fk_acteur", referencedColumnName="pk_acteur"))
	private Map<Role, Acteur> role = new HashMap<Role, Acteur>();
	
	public Film() {}
	
	public Film(String titre, String realisateur, LocalDate date_sortie, int duree) {
		super();
		this.titre = titre;
		this.realisateur = realisateur;
		this.date_sortie = date_sortie;
		this.duree = duree;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		titre = titre;
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

	public Map<Role, Acteur> getRole() {
		return role;
	}

	public void setRole(Map<Role, Acteur> role) {
		this.role = role;
	}
	
}
