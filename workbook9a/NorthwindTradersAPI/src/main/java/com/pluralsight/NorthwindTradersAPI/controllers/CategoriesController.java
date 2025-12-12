package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.daos.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {
    private CategoryDao dao;

    @Autowired
    public CategoriesController(CategoryDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path="/categories", method= RequestMethod.GET)
    public List<Category> getCategories() {
        return dao.getAll();
    }

    @RequestMapping(path="/categories/{id}", method=RequestMethod.GET)
    public Category getCategoryById(@PathVariable int id) {
        return dao.getById(id);
    }

    @RequestMapping(path="/categories", method=RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        Category newCategory = dao.insert(category);

        return newCategory;
    }
}
