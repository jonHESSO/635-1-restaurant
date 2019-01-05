package ch.hevs.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.hevs.businessobject.Owner;
import ch.hevs.businessobject.Restaurant;

public class EntitiesTest {
	
	@Test
	public void testInsertion() {
		EntityTransaction tx = null;
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarPU");
			EntityManager em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Owner owner = new Owner() ;
			owner.setEmail("email");
			owner.setName("flush");
			em.persist(owner);
			Restaurant restaurant = new Restaurant("resto","Rue de la rue","Sion", owner);
			owner.addRestaurant(restaurant);
			em.flush();
			System.out.println(owner.getEmail());
			
			
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace(System.out);
			tx.rollback();
		}
	}

}
