package fr.diginamic.banque.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte {

	private double taux;

	public LivretA() {
	}

	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
	}
	
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
}
