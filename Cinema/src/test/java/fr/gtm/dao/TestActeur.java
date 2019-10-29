package fr.gtm.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

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
		Map<String, Acteur> acteurs = dao.getAllActeursFromFilm(1);
		assertEquals("m", "McKellen", acteurs.get("Gandalf Le Gris").getNom());
		assertEquals("m", "Mortensen", acteurs.get("Aragorn").getNom());
	}
	
	@Test
	public void test_recuperation_Films_de_Acteurs() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinema");
		DAO dao = new DAO(emf);
		Map<String, Film> films = dao.getAllFilmsFromActeur(1);
		assertEquals("m", "Le Seigneur des anneaux : La Communauté de l'anneau", films.get("Gandalf Le Gris").getTitre());
	}

}
