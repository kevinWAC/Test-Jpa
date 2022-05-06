package fr.diginamic.banque.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	private double solde;
	
	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;
	
	@ManyToMany
	@JoinTable(name="compte_client",
		joinColumns= @JoinColumn(name="id_compte", referencedColumnName="id"),
		inverseJoinColumns= @JoinColumn(name="id_client", referencedColumnName="id")
	)
	private Set<Client> clients;
	
	 public Compte() {
		clients = new HashSet<>();
	 }
	
	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Set<Client> getclient() {
		return clients;
	}
	public void setclient(Set<Client> clients) {
		this.clients = clients;
	}
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
