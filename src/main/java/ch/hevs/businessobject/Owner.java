package ch.hevs.businessobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;	
	private String name ;
	private String email;	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)  //bi-directional 1-n mapping
	private List<Restaurant> restaurants;
	
	public Owner() {
		this.restaurants = new ArrayList<Restaurant>();
	}

	public Owner(String name, String email) {
		this.name = name;
		this.email = email;
		this.restaurants = new ArrayList<Restaurant>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	public void addRestaurant(Restaurant restaurant)
	{
		this.restaurants.add(restaurant);
	}
	
	public void removeRestaurant(Restaurant restaurant)
	{
		this.restaurants.remove(restaurant);
	}
	
	
}
