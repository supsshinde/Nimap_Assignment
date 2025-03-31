package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository pr;

	@Override
	public boolean savepro(Product p) {
		Product sp = pr.save(p);
		return sp != null;
	}

	@Override
	public List<Product> viewAllp() {
		return pr.findAll();
	}

	@Override
	public Product viewpbyid(int id) {

		Optional<Product> ip = pr.findById(id);
		
		if (ip.isPresent()) {
			
			return ip.get();
		} else {
			return null;
		}
	}

	@Override
	public Product updatep(Product p) {
		Optional<Product> op = pr.findById(p.getPid());
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delp(int id) {
		Optional<Product> op = pr.findById(id);
		if (op.isPresent()) {
			pr.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Page getAllProducts(int page, int size) {
		Pageable pagable=PageRequest.of(page, size);
        return pr.findAll(pagable);
	}

}