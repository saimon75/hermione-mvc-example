package it.hermione.mvc.service;

import it.hermione.mvc.model.Product;

import java.io.Serializable;
import java.util.List;

public interface ProductManager extends Serializable{

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();
    
}