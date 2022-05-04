package fr.diginamic.jpa;

import fr.diginamic.jpa.dao.impl.EmpruntDao;
import fr.diginamic.jpa.dao.impl.FactoryDao;
import fr.diginamic.jpa.entities.Client;
import fr.diginamic.jpa.entities.Emprunt;


public class TestBibliotheque {

	public static FactoryDao BIBLIO;

	public static void main(String[] args) {
		try {
			TestBibliotheque.BIBLIO = new FactoryDao("biblio");
			EmpruntDao empDao = new EmpruntDao(TestBibliotheque.BIBLIO);
			Emprunt e = new Emprunt();
			e.setId(1);
			System.out.println(empDao.getOne(e).getLivres());
			
			Client c = new Client();
			c.setId(1);
			System.out.println(empDao.getOne(e).getLivres());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
