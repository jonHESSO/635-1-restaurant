package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.bankservice.Bank;
import ch.hevs.businessobject.Account;
import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Restaurant;
import ch.hevs.starservice.Admin;
import ch.hevs.starservice.Star;

public class UserBean {
	
	private Star star ;
	private List<Restaurant> restaurants;
	private List<String> restaurantNames;
	


	private String selectedRestaurantName;
	
	
	@PostConstruct
    public void initialize() throws NamingException {
    	
    	// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
		star = (Star) ctx.lookup("java:global/TP12-WEB-EJB-PC-EPC-E-0.0.1-SNAPSHOT/StarBean!ch.hevs.starservice.Star");    	
		restaurants = star.getAllRestaurants();
		selectedRestaurantName = restaurants.get(0).getName();
		restaurantNames = new ArrayList<String>();
		for (Restaurant restaurant : restaurants) {
			restaurantNames.add(restaurant.getName());
		}
    	
    }
	
	public List<String> getRestaurantNames() {
		return restaurantNames;
	}


	public String getSelectedRestaurantName() {
		return selectedRestaurantName;
	}


	public void setSelectedRestaurantName(String selectedRestaurantName) {
		this.selectedRestaurantName = selectedRestaurantName;
	}
	
	

}
