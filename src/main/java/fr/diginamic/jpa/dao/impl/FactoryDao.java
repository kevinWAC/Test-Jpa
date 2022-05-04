package fr.diginamic.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Classe de type Service

public class FactoryDao {
	
	private final EntityManagerFactory emf;
	
	public FactoryDao(String unitePersistance) throws Exception {
		emf = Persistence.createEntityManagerFactory(unitePersistance);
	}

//	public EntityManagerFactory getEmf() {
//		return emf;
//	}
	
	public EntityManager getEm() throws Exception{
		return emf.createEntityManager();
	}
	
	public void close(EntityManager em) throws Exception {
		if(em.isOpen()) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
	private void close() throws Exception{
		if(emf.isOpen()) {
			emf.close();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		close();
	}

}
