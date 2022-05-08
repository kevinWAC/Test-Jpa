package fr.diginamic.banque.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name = "Compte.getClients", query = "select c from Client c where :compte MEMBER OF c.comptes"),
	@NamedQuery(name = "Compte.getOperations", query = "select o from Operation o where o.compte.id = :id")
})
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	private double solde;
	
//	@ManyToMany(mappedBy = "comptes")
//	private Set<Client> clients = new HashSet<>();
//
//	@OneToMany(mappedBy = "compte")
//	private Set<Operation> operations = new HashSet<>();


	public Compte() {
	}

	public Compte(String numero, double solde) {
		this.numero = numero;
		this.solde = solde;
	}

//	public Set<Operation> getOperations() {
//		return operations;
//	}
//
//	public void setOperations(Set<Operation> operations) {
//		this.operations = operations;
//	}
//
//	public Set<Client> getclient() {
//		return clients;
//	}
//
//	public void setclient(Set<Client> clients) {
//		this.clients = clients;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

}
