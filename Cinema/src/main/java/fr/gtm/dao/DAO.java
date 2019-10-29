package fr.gtm.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.entities.Acteur;
import fr.gtm.entities.Film;
import fr.gtm.entities.Role;

public class DAO {
	
	private EntityManagerFactory emf;

	public DAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void create(Film entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Film entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();	
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
        for (Map.Entry<String, Acteur> mapentry : film.getRoles().entrySet()) {
            acteurs.put(mapentry.getKey(),mapentry.getValue());
         }
		em.close();
		return acteurs;
	}
	
	public Map<String, Film> getAllFilmsFromActeur(long id) {
		EntityManager em = emf.createEntityManager();
		Acteur acteur = em.find(Acteur.class, id);
		Map<String, Film> films = new HashMap<String, Film>();
//		List<Film> films = new ArrayList<>();
        for (Map.Entry<String,Film> mapentry : acteur.getRoles().entrySet()) {
        	films.put(mapentry.getKey(),mapentry.getValue());
         }
		em.close();
		return films;
	}
	
	public Map<Role, Acteur> getAllActeursRoleFromFilm(long id) {
		EntityManager em = emf.createEntityManager();
		Film film = em.find(Film.class, id);
		Map<Role, Acteur> acteurs = new HashMap<Role, Acteur>();
        for (Map.Entry<Role,Acteur> mapentry : film.getRole().entrySet()) {
            acteurs.put(mapentry.getKey(),mapentry.getValue());
         }
		em.close();
		return acteurs;
	}
	
}
