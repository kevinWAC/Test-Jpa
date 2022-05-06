package fr.diginamic.banque;

import java.time.LocalDate;

import fr.diginamic.banque.dao.impl.BanqueDao;
import fr.diginamic.banque.dao.impl.ClientDao;
import fr.diginamic.banque.dao.impl.CompteDao;
import fr.diginamic.banque.entities.Adresse;
import fr.diginamic.banque.entities.Banque;
import fr.diginamic.banque.entities.Client;
import fr.diginamic.banque.entities.Compte;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class TestBanque {

	public static FactoryDao BANQUE;
	
	public static void main(String[] args) {
		try {
			TestBanque.BANQUE = new FactoryDao("banque");
			BanqueDao bDao = new BanqueDao(TestBanque.BANQUE);
			Banque ce = new Banque();
			ce.setNom("Caisse d'epargne");
			bDao.add(ce);
			
			ClientDao clDao = new ClientDao(TestBanque.BANQUE);
			Adresse a = new Adresse(12, "rue des chemins", 44000, "Nantes"); 
			Client cl = new Client("Kévin","Ulreich",LocalDate.of(2020, 1, 8));
			cl.setAdresse(a);
			cl.setBanque(ce);

			clDao.add(cl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
