package ch.hevs.starservice;

<<<<<<< HEAD
=======

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import ch.hevs.businessobject.*;


public class AdminBean {
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ch.hevs.businessobject.*;

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

		
=======
	
	
	private List<Restaurant> restaurants;
	private List<String> retaurantName;
	private List<Owner> owners;
	private List<String> ownerName;
	private List<Rating> ratings;
	private List<Menu> menus;
	private List<String> menuName;
	
	
	
	
>>>>>>> refs/remotes/origin/master
}
