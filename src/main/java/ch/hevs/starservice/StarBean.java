package ch.hevs.starservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Menu;
import ch.hevs.businessobject.Owner;
import ch.hevs.businessobject.Rating;
import ch.hevs.businessobject.Restaurant;

public class StarBean implements Star{
	
	
	private EntityManager em;

	@Override
	public List<Restaurant> getAllRestaurants() {
		// TODO Auto-generated method stub
		return (List<Restaurant>) em.createQuery("FROM Restaurant").getResultList();
	}

	@Override
	public Owner getOwnerFromRestaurant(String restaurantName) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT o FROM Restaurant re, IN(re.Owner)o WHERE re.Name = :restaurantName").setParameter("restaurantName", restaurantName);
		
		return (Owner) query.getSingleResult();
	}

	@Override
	public Menu getMenuFromRestaurant(String restaurantName) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT m FROM Restaurant re, IN(re.Menu)o WHERE re.Name = :restaurantName").setParameter("restaurantName", restaurantName);
		
		return (Menu) query.getSingleResult();
	}

	@Override
	public List<Rating> getRatingsFromRestaurant(String restaurantName) {
		// TODO Auto-generated method stub
		return (List<Rating>) em.createQuery("SELECT ra FROM Restaurant re, IN(re.Ratings)ra WHERE re.Name = :restaurantName").setParameter("restaurantName", restaurantName).getResultList();
	}

	@Override
	public void addRating(Rating rating, String restaurantName) {
		// TODO Auto-generated method stub

		 Restaurant restaurant = (Restaurant) em.createQuery("FROM Restaurant WHERE name =:restaurantName").setParameter("restaurantName", restaurantName).getSingleResult();
		 em.persist(rating);
		 restaurant.addRating(rating); 
		 em.flush();
		 
		 
		 
	}

}
