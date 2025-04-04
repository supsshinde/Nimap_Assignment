package com.example.demo.service;

import java.util.*;
import org.springframework.data.domain.Page;
import com.example.demo.model.Product;

public interface ProductService {
	public Page getAllProducts(int page, int size);
	boolean savepro(Product p);
	List<Product> viewAllp();
	Product viewpbyid(int id);
	Product updatep(Product c);
	boolean delp(int id);
	public Page<Product> getProductByName(String pname, int page, int size);

}
