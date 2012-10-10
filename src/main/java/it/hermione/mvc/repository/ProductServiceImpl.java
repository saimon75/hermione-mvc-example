package it.hermione.mvc.repository;

import it.hermione.mvc.model.Product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("springJpaProductService")
@Repository
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		System.out.println("findAll");
		
		return productRepository.findAll();
		//return Lists.newArrayList(productRepository.findAll());
	}

	@Transactional(readOnly = true)
	public List<Product> findByFirstName(String description) {
		System.out.println("description " + description);
		return productRepository.findByDescription(description);
	}

	public Product saveProduct(Product product) {
		if (product.getId() == null) {
			em.persist(product);
			return product;
		} else {
			return em.merge(product);
		}
		
	}

}
