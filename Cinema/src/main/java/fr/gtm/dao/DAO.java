package fr.gtm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.entities.Acteur;
import fr.gtm.entities.Film;

public class DAO {
	
	private EntityManagerFactory emf;

	public DAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public List<Acteur> getAllActeur() {
		EntityManager em = emf.createEntityManager();
		List<Acteur> acteurs = em.createNamedQuery("Acteurs.All",Acteur.class)
											.getResultList();
		em.close();
		return acteurs;
	}
	
	public List<Film> getAllFilm() {
		EntityManager em = emf.createEntityManager();
		List<Film> acteurs = em.createNamedQuery("Film.All",Film.class)
											.getResultList();
		em.close();
		return acteurs;
	}
	
	public List<Acteur> getAllActeursFromFilm(long id) {
		EntityManager em = emf.createEntityManager();
		Film film = em.find(Film.class, id);
		List<Acteur> acteurs = new ArrayList<>();
		for(Acteur a : film.getDistribution()) {
			acteurs.add(a);
		}
		em.close();
		return acteurs;
	}
	
	public List<Film> getAllFilmsFromActeur(long id) {
		EntityManager em = emf.createEntityManager();
		Acteur acteur = em.find(Acteur.class, id);
		List<Film> films = new ArrayList<>();
		for(Film f : acteur.getFilmographie()) {
			films.add(f);
		}
		em.close();
		return films;
	}
	
}
