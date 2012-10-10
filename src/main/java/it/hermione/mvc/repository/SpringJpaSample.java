package it.hermione.mvc.repository;

import it.hermione.mvc.model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class SpringJpaSample {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:META-INF/spring/app-context.xml");
		String date = "1975/12/12";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/DD/MM");
		Date utilDate = formatter.parse(date);
		// Contact dave = new Contact("Dave", "Matthews", utilDate);
		// Contact carter = new Contact("Carter", "aaaaa", utilDate);

		Product product = new Product("description", 2.0);
		System.out.println(ctx.getBean(ProductService.class).toString());
		createDB();
		ProductService productService = ctx.getBean(ProductService.class);
		System.out.println(product.toString());
		productService.saveProduct(product);
		// contactService.save(dave);
		List<Product> products = productService.findAll();
		listProducts(products);
	}

	private static void listProducts(List<Product> products) {
		System.out.println("LIST PRODUCTS");
		for (Product product : products) {
			System.out.println("description " + product.getDescription());
		}

	}

	private static void createDB() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.H2)
				.addScript("schema.sql")
				.addScript("test-data.sql").build();
	}
}
