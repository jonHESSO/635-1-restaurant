package ch.hevs.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.hevs.businessobject.Owner;
<<<<<<< HEAD
import ch.hevs.businessobject.Rating;
=======
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
			tx.rollback();
		}
	}
	
	@Test
	public void testRating() {
		EntityTransaction tx = null;
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarPU");
			EntityManager em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Owner owner = new Owner() ;
			owner.setEmail("email");
			owner.setName("dude");
			em.persist(owner);
			Restaurant restaurant = new Restaurant("rated restaurant","Rue de la rue","Sion", owner);
			owner.addRestaurant(restaurant);
			Rating rating = new Rating(3,"Pretty good");
			em.persist(rating);
			restaurant.addRating(rating);
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
	
	@Test
	public void testDelete() {
		EntityTransaction tx = null;
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarPU");
			EntityManager em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			List<Owner> owners = (List<Owner>) em.createQuery("FROM Owner WHERE name='dude'").getResultList();
			for (Owner owner : owners) {
				em.remove(owner);
			}
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
=======
>>>>>>> refs/remotes/origin/master
			tx.rollback();
		}
	}

}
