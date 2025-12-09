package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private List<Product> products;

    public SimpleProductDao() {
        products = new ArrayList<>();
        products.add(new Product(1, "Apple", "Fruit", 1.00));
        products.add(new Product(2, "Banana", "Fruit", 2.00));
        products.add(new Product(3, "Whole Milk", "Dairy", 5.00));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
