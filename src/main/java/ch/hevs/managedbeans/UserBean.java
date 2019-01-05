package ch.hevs.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Owner;
import ch.hevs.businessobject.Restaurant;
import ch.hevs.starservice.Star;

public class UserBean {
	
	
	private List<Restaurant> restaurants;
	private Restaurant restaurant;
	private Owner owner;
	private String comment;
	private Star star;
	
	@PostConstruct
	public void initialize() throws NamingException {
		InitialContext ctx = new InitialContext();
		star = (Star) ctx.lookup("java:global/SCHNYDER-HAZIRI-WEB-EJB-0.0.1-SNAPSHOT/StarBean!ch.hevs.starservice.Star");
		
		
		
		
	}
	
	
	
	
	
	

}
