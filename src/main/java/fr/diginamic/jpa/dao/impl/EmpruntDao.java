package fr.diginamic.jpa.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.diginamic.jpa.dao.Idao;
import fr.diginamic.jpa.entities.Emprunt;
import fr.diginamic.jpa.entities.Fournisseur;

public class EmpruntDao extends Dao implements Idao<Emprunt> {

	public EmpruntDao(FactoryDao fd) {
		super(fd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Emprunt e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Emprunt e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Emprunt e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Emprunt getOne(Emprunt e) throws Exception {
		TypedQuery<Emprunt> tqb = fd.getEm().createQuery("select em from Emprunt em where em.id = :id", Emprunt.class);
			tqb.setParameter("id", e.getId());
			
		return tqb.getResultList().get(0);
	}

	@Override
	public List<Emprunt> getAll() throws Exception {
		TypedQuery<Emprunt> tqb = fd.getEm().createQuery("select em from Emprunt em", Emprunt.class);
		return tqb.getResultList();
	}

	
}
