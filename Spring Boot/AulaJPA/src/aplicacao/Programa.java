package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	
	public static void main(String[] args) {
		
		/*
		 * Já estão inseridos no banco de dados
		Pessoa p1 = new Pessoa (null, "Carlos da Silva", "carlinhos@gmail.com");
		Pessoa p2 = new Pessoa (null, "João Bento", "bentinho@gmail.com");
		Pessoa p3 = new Pessoa (null, "Fabiana Cardoso", "fabicardoso@gmail.com");
		*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		//em.getTransaction().begin();
		
		/* Também já estão persistidos
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		*/
		
		//em.getTransaction().commit();
		
		//Pessoa p = em.find(Pessoa.class, 2);
		//System.out.println(p);
		 
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		
		em.close();
		emf.close();
		
		
	}
	
}
