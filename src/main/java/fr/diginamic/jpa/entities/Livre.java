package fr.diginamic.jpa.entities;


import javax.persistence.*;


@Entity
@Table(name="livre")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="AUTEUR", length = 50, nullable = false)
	private String auteur;
	
	@Column(name="TITRE", length = 255, nullable = false)
	private String titre;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
