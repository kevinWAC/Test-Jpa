package fr.diginamic.jpa;

import java.util.List;

import javax.persistence.*;

import fr.diginamic.jpa.entities.Livre;

public class TestJpa {

	public static void main(String[] args) {
		EntityManagerFactory efm = null;
		try {
			
			efm = Persistence.createEntityManagerFactory("biblio");
			EntityManager em = efm.createEntityManager();

			Livre livre = em.find(Livre.class, 1);
			System.out.println("Auteur: " + livre.getAuteur() + " Titre: " + livre.getTitre() );
			
			em.getTransaction().begin();
			
			Livre newLivre = new Livre();
			
			newLivre.setAuteur("Emile Zola");
			newLivre.setTitre("la bête humaine");
			em.persist(newLivre);
			em.getTransaction().commit();
			
			
			em.getTransaction().begin();
			Livre livreUpdate = em.find(Livre.class, 5) ;
			if(livreUpdate != null) {
				livreUpdate.setTitre("Du plaisir dans la cuisine 5");
				em.getTransaction().commit();				
			} else {
				em.getTransaction().rollback();
			}
			
			
			em.getTransaction().begin();
			Livre livreDelete= em.find(Livre.class, 23);
			em.remove(livreDelete);
			em.getTransaction().commit();
			
			
			TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre='Germinal' ", Livre.class);
			List<Livre> livreresult = query.getResultList();
			for (Livre livre2 : livreresult) {
				System.out.println(livre2.getAuteur());
				System.out.println(livre2.getTitre());
			}
			
			TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.auteur='Jules Verne' ", Livre.class);
			List<Livre> livreresult2 = query2.getResultList();
			for (Livre livre3 : livreresult2) {
				System.out.println(livre3.getAuteur());
				System.out.println(livre3.getTitre());
			}
			
			TypedQuery<Livre> query3 = em.createQuery("select l from Livre l", Livre.class);
			List<Livre> livreresult3 = query3.getResultList();
			for (Livre livre3 : livreresult3) {
				System.out.println("Auteur : " + livre3.getAuteur() + "Titre : " + livre3.getTitre());
			}
			
			
			em.close();
			efm.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
