package ch.hevs.starservice;

import java.util.List;

import javax.ejb.Local;
import ch.hevs.businessobject.*;

@Local
public interface Star {

	//All restaurants
	public List<Restaurant> getAllRestaurants();
	
	//Single restaurant
	//Owner from restaurant
	public Owner getOwnerFromRestaurant(String restaurantName) ;
	//Menu from restaurant
	public Menu getMenuFromRestaurant(String restaurantName) ;
	//Ratings from restaurant
	public List<Rating> getRatingsFromRestaurant(String restaurantName) ;
	//Add new rating
	public void addRating(Rating rating, String restaurantName) ;
	
}
