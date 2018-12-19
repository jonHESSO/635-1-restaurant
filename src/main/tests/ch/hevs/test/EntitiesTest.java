package ch.hevs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.hevs.businessobject.Owner;

public class EntitiesTest {
	
	@Test
	public void test() {
		EntityTransaction tx = null;
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarPU");
			EntityManager em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Owner owner = new Owner() ;
			owner.setEmail("email");
			owner.setName("jon");
			System.out.println(owner.getEmail());
			em.persist(owner);
			
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
		}
	}

}
