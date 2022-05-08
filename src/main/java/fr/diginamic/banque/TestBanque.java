package fr.diginamic.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fr.diginamic.banque.dao.impl.BanqueDao;
import fr.diginamic.banque.dao.impl.ClientDao;
import fr.diginamic.banque.dao.impl.CompteDao;
import fr.diginamic.banque.dao.impl.OperationDao;
import fr.diginamic.banque.entities.Adresse;
import fr.diginamic.banque.entities.AssuranceVie;
import fr.diginamic.banque.entities.Banque;
import fr.diginamic.banque.entities.Client;
import fr.diginamic.banque.entities.Compte;
import fr.diginamic.banque.entities.LivretA;
import fr.diginamic.banque.entities.Operation;
import fr.diginamic.banque.entities.Virement;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class TestBanque {

	public static FactoryDao BANQUE;
	
	public static void main(String[] args) {
		try {
			TestBanque.BANQUE = new FactoryDao("banque");
			BanqueDao bDao = new BanqueDao(TestBanque.BANQUE);
			CompteDao coDao = new CompteDao(TestBanque.BANQUE);
			ClientDao clDao = new ClientDao(TestBanque.BANQUE);
			OperationDao opDao = new OperationDao(TestBanque.BANQUE);

			Banque ce = new Banque();
			ce.setNom("Caisse d'Epargne");
			bDao.add(ce);
			
			Banque bp = new Banque();
			bp.setNom("Banque Postale");
			bDao.add(bp);
						
			Adresse a = new Adresse(13, "Rue de l'etang", 44000, "Nantes"); 
			Client cl = new Client("Marc","Fauché",LocalDate.of(2020, 1, 8));
			cl.setAdresse(a);
			cl.setBanque(ce);
			
			clDao.add(cl);
			
			Adresse a2 = new Adresse(4, "Rue des chemins", 44100, "Rezé"); 
			Client cl2 = new Client("Luc","Dupont",LocalDate.of(2000, 3, 7));
			cl2.setAdresse(a2);
			cl2.setBanque(bp);
			
			clDao.add(cl2);
			
			Compte co = new Compte("AEF1201",1300.00);
			coDao.add(co);
			
			Compte co2 = new Compte("ABP400",2500.00);
			coDao.add(co2);
			
			cl.getComptes().add(co);
			clDao.update(cl);
			
			cl2.getComptes().add(co);
			cl2.getComptes().add(co2);
			clDao.update(cl2);
			
			
			Compte av = new AssuranceVie("AV273773", 30000, LocalDate.of(2000,02,02), 1.0);
			coDao.add(av);
			
			Compte la = new LivretA("123434", 220.00, 1.0);
			coDao.add(la);
			
			cl2.getComptes().add(la);
			clDao.update(cl2);
			
			Operation op = new Virement(LocalDateTime.now(), 100000.0, "Paie alternance Mai", "Kévin Ulreich");
			op.setCompte(la);
			opDao.add(op);
			
			Operation op2 = new Virement(LocalDateTime.now(), 3000000.0, "Paie de Mai", "Christophe Germain");
			op2.setCompte(av);
			opDao.add(op2);
			
			Operation op3 = new Operation(LocalDateTime.now(), 329, "opération");
			Operation op4 = new Operation(LocalDateTime.now(), 100, "opération");
			
			op3.setCompte(co2);
			opDao.add(op3);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
