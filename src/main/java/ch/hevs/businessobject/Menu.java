package ch.hevs.businessobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Menu")
public class Menu {
	


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	@Column(name="contenu")
	private String content;
	
	
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
