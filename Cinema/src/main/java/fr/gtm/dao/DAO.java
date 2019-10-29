package fr.gtm.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String, Acteur> getAllActeursFromFilm(long id) {
		EntityManager em = emf.createEntityManager();
		Film film = em.find(Film.class, id);
		Map<String, Acteur> acteurs = new HashMap<String, Acteur>();
//		List<Acteur> acteursList = getAllActeur();
//		Acteur acteur = new Acteur();
//		String role;
//		for(String role : film.getRoles().keySet()) {
//			acteur = film.getRoles();
//			acteurs.put(,a);
//		}
        for (Map.Entry mapentry : film.getRoles().entrySet()) {
            acteurs.put((String)mapentry.getKey(),(Acteur)mapentry.getValue());
         }
		em.close();
		return acteurs;
	}
	
	public Map<String, Film> getAllFilmsFromActeur(long id) {
		EntityManager em = emf.createEntityManager();
		Acteur acteur = em.find(Acteur.class, id);
		Map<String, Film> films = new HashMap<String, Film>();
//		List<Film> films = new ArrayList<>();
        for (Map.Entry mapentry : acteur.getRoles().entrySet()) {
        	films.put((String)mapentry.getKey(),(Film)mapentry.getValue());
         }
		em.close();
		return films;
	}
	
}
