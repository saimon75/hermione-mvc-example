package it.hermione.mvc.repository;

import it.hermione.mvc.model.Product;

import java.util.List;

public interface ProductService {
	
	public List<Product> findAll();

    public Product saveProduct(Product prod);

}
