package it.hermione.mvc.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4081768108194463575L;
	private Long id;
	private String description;
	private Double price;

	public Product() {

	}

	public Product(String description, Double price) {
		this.description = description;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: " + description + ";");
		buffer.append("Price: " + price);
		return buffer.toString();
	}
}
