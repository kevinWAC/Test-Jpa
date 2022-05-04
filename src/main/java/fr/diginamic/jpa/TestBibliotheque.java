package fr.diginamic.jpa;

import fr.diginamic.jpa.dao.impl.ClientDao;
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
			Emprunt em = empDao.getOne(e);
			System.out.println(em);
			
			ClientDao cliDao = new ClientDao(TestBibliotheque.BIBLIO);
			Client c = new Client();
			c.setId(1);
			try {
				cliDao.getOne(c).getEmprunts().forEach(eprt->System.out.println("Date de début: " + eprt.getDate_debut() + " Date de fin : " + eprt.getDate_fin()));
			} catch (Exception ex) {
				System.err.println(ex);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
