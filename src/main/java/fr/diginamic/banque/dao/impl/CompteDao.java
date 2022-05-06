package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entities.Compte;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class CompteDao extends Dao implements Idao<Compte> {

	public CompteDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Compte e) throws Exception {
		EntityManager em = null;
		try {
			em = fd.getEm();
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		} finally {
			fd.close(em);
		}
	}

	@Override
	public boolean update(Compte e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Compte e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Compte getOne(Compte e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
