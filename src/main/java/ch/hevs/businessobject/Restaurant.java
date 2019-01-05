package ch.hevs.businessobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id ;	
	private String name;
	private String adress;
	private String city ;
	@OneToMany(cascade = CascadeType.ALL)  //uni-directional 1-n mapping
	private List<Rating> ratings ;
	@OneToOne  //uni-direction 0-1 mapping
	@JoinColumn(name = "FK_MENU", nullable = true)
	private Menu menu ;	
	@ManyToOne //bi-directional 1-n mapping
	@JoinColumn(name = "FK_OWNER", nullable = false)
	private Owner owner ;
	
	public Restaurant() {
		this.ratings = new ArrayList<Rating>();
	}

	public Restaurant(String name, String adress, String city, Owner owner) {
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.owner = owner;
		this.ratings = new ArrayList<Rating>();
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public void addRating(Rating rating)
	{
		this.ratings.add(rating);
	}
	
}
