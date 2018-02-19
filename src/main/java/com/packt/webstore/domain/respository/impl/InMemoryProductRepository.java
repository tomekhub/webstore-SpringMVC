package com.packt.webstore.domain.respository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s 4-calowy smartfon");
		iphone.setCategory("Smartfon");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		
		Product laptop_dell = new Product("P1235", "Dell Inspirion", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspirion 14-calowy laptop z procesorem i3");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);
		
		Product tablet_nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
		tablet_nexus.setDescription("Google Nexus 7 tablet z 4-rdzeniowym procesorem i 7-calowym wyœwietlaczem");
		tablet_nexus.setCategory("Tablet");
		tablet_nexus.setManufacturer("Google");
		tablet_nexus.setUnitsInStock(1000);
		
		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_nexus);
	}
	
	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	public Product getProductById(String productId) {
		Product productById = null;
		for(Product product : listOfProducts) {
			if(product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		if(productById == null)
			throw new IllegalArgumentException("Brak produktu o wskazanym id: " + productId);
		return productById;
	}

}
