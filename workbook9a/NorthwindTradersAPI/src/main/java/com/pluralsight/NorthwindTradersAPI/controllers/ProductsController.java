package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.daos.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {
    private ProductDao dao;

    @Autowired
    public ProductsController(ProductDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path="/products", method=RequestMethod.GET)
    public List<Product> getProducts() {
        return dao.getAll();
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.GET)
    public Product getProductById(@PathVariable int id) {
        return dao.getById(id);
    }

    @RequestMapping(path="/products", method=RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        Product newProduct = dao.insert(product);

        return newProduct;
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.PUT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        dao.update(id, product);
    }
}
