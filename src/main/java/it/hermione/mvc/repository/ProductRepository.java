package it.hermione.mvc.repository;

import it.hermione.mvc.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product save(Product contact);

	public List<Product> findByDescription(String description);
}
