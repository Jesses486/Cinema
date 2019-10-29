package fr.gtm.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.dao.DAO;
import fr.gtm.entities.Acteur;
import fr.gtm.entities.Film;

public class TestActeur {

	@BeforeClass
	public static void  before() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
	}
	
//	@AfterClass
//	public static void  after() {
//		if(emf != null) {
//			emf.close();
//		}
//	}
	
	@Test
	public void test_recuperation_acteurs() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
		DAO dao = new DAO(emf);
		List<Acteur> acteurs = dao.getAllActeur();
		assertEquals("m", "McKellen", acteurs.get(0).getNom());
	}
	
	@Test
	public void test_recuperation_films() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
		DAO dao = new DAO(emf);
		List<Film> acteurs = dao.getAllFilm();
		assertEquals("m", "Le Seigneur des anneaux : La Communauté de l'anneau", acteurs.get(0).getTitre());
	}
	
	@Test
	public void test_recuperation_Acteurs_de_Film() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
		DAO dao = new DAO(emf);
		List<Acteur> acteurs = dao.getAllActeursFromFilm(1);
		assertEquals("m", "McKellen", acteurs.get(0).getNom());
		assertEquals("m", "Mortensen", acteurs.get(1).getNom());
	}
	
	@Test
	public void test_recuperation_Films_de_Acteurs() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
		DAO dao = new DAO(emf);
		List<Film> films = dao.getAllFilmsFromActeur(1);
		assertEquals("m", "Le Seigneur des anneaux : La Communauté de l'anneau", films.get(0).getTitre());
		assertEquals("m", "Le Seigneur des anneaux : Les Deux Tours", films.get(1).getTitre());
		assertEquals("m", "Le Seigneur des anneaux : Le Retour du roi", films.get(2).getTitre());
		assertEquals("m", "X-Men", films.get(3).getTitre());
	}
	
//	@Test
//	public void test_recuperation_Films_de_Acteurs_de_Films() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
//		DAO dao = new DAO(emf);
//		List<Acteur> acteurs = dao.getAllActeursFromFilm(1);
//		for(Acteur a : acteurs) {
//			a.setFilmographie(dao.getAllFilmsFromActeur(a.getId()));
//		}
//		assertEquals("m", "Le Seigneur des anneaux : La Communauté de l'anneau", acteurs.get(0).getFilmographie().get(0));
//		assertEquals("m", "Le Seigneur des anneaux : Les Deux Tours", acteurs.get(0).getFilmographie().get(1));
//		assertEquals("m", "Le Seigneur des anneaux : Le Retour du roi", acteurs.get(0).getFilmographie().get(2));
//		assertEquals("m", "X-Men", acteurs.get(0).getFilmographie().get(3));
//	}

}
