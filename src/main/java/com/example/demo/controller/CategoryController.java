package com.example.demo.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService c1;
//
//	@GetMapping
//	public Page<Category> getAllCategory(@RequestParam(defaultValue = "0") int page,
//			@RequestParam(defaultValue = "5") int size) {
//		return c1.getAllCategory(page, size);
//
//	}

	@PostMapping()
	public String home1(@RequestBody Category c) {
		boolean b = c1.saveCat(c);
		if (b) {
			return "Record Save Success";
		} else {
			return "Record not Success";
		}
	}

	@GetMapping()
	public List<Category> getAllCat() {
		List<Category> list = c1.viewAllc();
		return list;
	}

	@GetMapping(value = "/{id}")
	public Category viewbyid(@PathVariable int id) {
		Category catid = c1.viewbyid(id);
		if (catid != null) {
			return catid;
		} else {
			return null;
		}
	}

	@PutMapping(value = "/{id}")
	public Category updatebyid(@RequestBody Category c) {
		Category cat1 = c1.updatcat(c);
		if (cat1 != null) {
			cat1.setName(c.getName());
			c1.saveCat(cat1);
			return cat1;
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/{id}")
	public String delbyid(@PathVariable int id) {
		boolean b = c1.delcat(id);
		if (b) {
			return "Record deleted";
		} else {
			return "record not found";
		}
	}

}
