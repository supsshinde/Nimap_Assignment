package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	ProductService p1;

	@PostMapping()
	public String productp(@RequestBody Product product) {

		boolean b = p1.savepro(product);
		if (b) {
			return "Record Save Success";
		} else {
			return "Record not Success";
		}
	}

	@GetMapping()
	public List<Product> getAllp() {
		List<Product> list = p1.viewAllp();
		return list;
	}

	@GetMapping(value = "/{id}")
	public Product viewpbyid(@PathVariable int id) {
		Product pid = p1.viewpbyid(id);

		System.out.println(pid.getPname());

		if (pid != null) {
			return pid;
		} 
		else {
			return null;
		}
	}

	@PutMapping(value = "/{id}")
	public Product updatepbyid(@RequestBody Product p) {
		Product up = p1.updatep(p);
		if (up != null) {
			up.setPname(p.getPname());
			up.setPrice(p.getPrice());
			up.setCategory(p.getCategory());
			p1.savepro(up);
			return up;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/{id}")
	public String delbyid(@PathVariable int id) {
		boolean b = p1.delp(id);
		if (b) {
			return "Record deleted";
		} else {
			return "record not found";
		}
	}
	
	 @GetMapping("/searchProductByName/{n}/{page}/{size}")
	    public Page<Product> getCategoryByName(@PathVariable("n") String pname, @PathVariable("page") int page, @PathVariable("size") int size) 
	 {
	        return p1.getProductByName(pname, page, size);
	    }
}