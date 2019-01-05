package ch.hevs.starservice;


import java.util.List;




import ch.hevs.businessobject.*;



import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


@Stateful
public class AdminBean implements Admin{
	
	@PersistenceContext(name = "StarPU", type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	@Override
	public List<Owner> getAllOwners() {
		return (List<Owner>) em.createQuery("FROM Owner").getResultList();
	}

	@Override
	public List<Restaurant> getRestaurantsFromOwner(String ownerName) {
		return (List<Restaurant>) em.createQuery("SELECT o.restaurants FROM Owner o where o.name=:ownerName").setParameter("ownerName", ownerName).getResultList();
	}

	@Override
	public Owner getOwner(String ownerName) {
		return (Owner) em.createQuery("FROM Owner o WHERE o.name=:ownerName").setParameter("ownerName", ownerName);

	}

	@Override
	public void editOwner(Owner owner) {
		em.persist(owner);	
	}

	@Override
	public void deleteOwner(String ownerName) {
		Owner owner = (Owner)em.createQuery("FROM Owner WHERE name=:ownerName").setParameter("ownerName", ownerName).getSingleResult();
		em.remove(owner);	
	}

	@Override
	public void createOwner(Owner owner) {
		em.persist(owner);
	}

	@Override
	public Restaurant getRestaurant(String restaurantName) {
		return (Restaurant) em.createQuery("FROM Restaurant WHERE name=:restaurantName").setParameter("restaurantName", restaurantName).getSingleResult();
	}

	@Override
	public void editRestaurant(Restaurant restaurant) {
		em.persist(restaurant);
	}

	@Override
	public void deleteRestaurant(String restaurantName) {
		Restaurant restaurant = (Restaurant) em.createQuery("FROM Restaurant WHERE name=:restaurantName").setParameter("restaurantName", restaurantName).getSingleResult();
		em.remove(restaurant);
	}

	@Override
	public void createRestaurant(Restaurant restaurant) {
		em.persist(restaurant);		
	}

	@Override
	public Menu getMenu(String restaurantName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editMenu(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMenu(String restaurantName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createMenu(Menu menu, String restaurantName) {
		// TODO Auto-generated method stub
		
	}
}
