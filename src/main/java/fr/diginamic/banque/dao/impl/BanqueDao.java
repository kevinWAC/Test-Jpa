package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entities.Banque;
import fr.diginamic.jpa.dao.impl.FactoryDao;
import fr.diginamic.jpa.entities.Article;
import fr.diginamic.jpa.entities.Bon;
import fr.diginamic.jpa.entities.Client;

public class BanqueDao extends Dao implements Idao<Banque> {

	public BanqueDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Banque e) throws Exception {
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
	public boolean update(Banque e) throws Exception {
		return false;
	}

	@Override
	public boolean delete(Banque e) throws Exception {
		return false;
	}

	@Override
	public Banque getOne(Banque e) throws Exception {
		return null;
	}

	@Override
	public List<Banque> getAll() throws Exception {
		TypedQuery<Banque> tqb = fd.getEm().createQuery("select b from Banque b", Banque.class);
		return tqb.getResultList();
	}

}
