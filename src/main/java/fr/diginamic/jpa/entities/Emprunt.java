package fr.diginamic.jpa.entities;

import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="DATE_DEBUT")
	private LocalTime date_debut;
	
	@Column(name="DATE_FIN")
	private LocalTime date_fin;
	
	@Column(name="DELAI")
	private Integer delai;
		
	
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private Set<Livre> livres;
	
	public Set<Livre> getLivres() {
		return livres;
	}
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	public Client getClients() {
		return client;
	}
	public void setClients(Client client) {
		this.client = client;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalTime getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(LocalTime date_debut) {
		this.date_debut = date_debut;
	}
	public LocalTime getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalTime date_fin) {
		this.date_fin = date_fin;
	}
	public Integer getDelai() {
		return delai;
	}
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	@Override
	public String toString() {
		
		return "Emprunt date de début : " + date_debut + " Livre :" + livres;
	}

}
