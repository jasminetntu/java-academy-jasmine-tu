package com.pluralsight.NorthwindTradersAPI.daos;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAll();
    Product getById(int id);
    Product insert(Product product);
}
