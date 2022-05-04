package fr.diginamic.jpa.dao.impl;

import java.util.List;

import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.entities.Livre;

public class LivreDao extends Dao implements Idao<Livre> {

	public LivreDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Livre e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Livre e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Livre e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Livre getOne(Livre e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livre> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
