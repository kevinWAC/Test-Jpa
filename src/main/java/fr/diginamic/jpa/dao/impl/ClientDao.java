package fr.diginamic.jpa.dao.impl;

import java.util.List;

import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.entities.Client;

public class ClientDao extends Dao implements Idao<Client> {

	public ClientDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Client e) throws Exception {
		// TODO Auto-generated method stub
		return false;
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
