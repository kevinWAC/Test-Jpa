package fr.diginamic.banque.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import fr.diginamic.banque.dao.Idao;
import fr.diginamic.banque.entities.Client;
import fr.diginamic.jpa.dao.impl.FactoryDao;

public class ClientDao extends Dao implements Idao<Client> {

	public ClientDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Client e) throws Exception {
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
	public boolean update(Client e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client getOne(Client e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
