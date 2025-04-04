package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository cr;

	@Override
	public boolean saveCat(Category c) {
		Category c11 = cr.save(c);
		return c11 != null;
	}

	@Override
	public List<Category> viewAllc() {
		return cr.findAll();
	}

	@Override
	public Category viewbyid(int id) {
		Optional<Category> ic = cr.findById(id);
		if (ic.isPresent()) {
			return ic.get();
		} else {
			return null;
		}
	}

	@Override
	public Category updatcat(Category c) {
		Optional<Category> o = cr.findById(c.getCategory_id());
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delcat(int id) {

		Optional<Category> r = cr.findById(id);
		if (r.isPresent()) {
			cr.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Page<Category> getAllCategory(int page, int size) {
		Pageable pagable=PageRequest.of(page, size);
		return cr.findAll(pagable);
	}
	
	public Page<Category> getCategoryByName(String name, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		int totalPages = pageable.getPageSize();
		int pageNum = pageable.getPageNumber();
		System.out.println(pageNum);
		System.out.println(totalPages);
		return cr.findByName(name, pageable);
	}

}
