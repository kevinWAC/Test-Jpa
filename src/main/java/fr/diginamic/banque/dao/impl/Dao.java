package fr.diginamic.banque.dao.impl;

import fr.diginamic.jpa.dao.impl.FactoryDao;

public abstract class Dao {
	
	protected final FactoryDao fd;
	
	public Dao(FactoryDao fd) {
		this.fd = fd;
	}
	
}
