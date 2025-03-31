package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.example.demo.model.Category;

public interface CategoryService {

	public Page getAllCategory(int page, int size);

	boolean saveCat(Category c);

	List<Category> viewAllc();

	Category viewbyid(int id);

	Category updatcat(Category c);

	boolean delcat(int id);

}
