package ch.hevs.starservice;

import java.util.List;

import ch.hevs.businessobject.*;

public interface Admin {
	
	public List<Owner> getAllOwners();
	
	public List<Restaurant> getRestaurantsFromOwner(String ownerName);
	
	public Owner getOwner(String ownerName);
	public void editOwner(Owner owner);
	public void deleteOwner(String ownerName);
	public void createOwner(Owner owner);
	
	public Restaurant getRestaurant(String restaurantName);
	public void editRestaurant(Restaurant restaurant);
	public void deleteRestaurant(String restaurantName);
	public void createRestaurant(Restaurant restaurant);
	
	public Restaurant getMenu(String restaurantName);
	public void editMenu(Menu menu);
	public void deleteMenu(String restaurantName);
	public void createMenu(Menu menu, String restaurantName);

}
