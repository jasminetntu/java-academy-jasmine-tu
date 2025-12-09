package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final SimpleProductDao simpleProductDao;

    @Autowired
    public ProductService(SimpleProductDao simpleProductDao) {
        this.simpleProductDao = simpleProductDao;
    }

    private void listProducts() {
        for (Product p : simpleProductDao.getAll()) {
            System.out.println(p);
        }
    }

    private void addProduct(Product product) {
        simpleProductDao.add(product);
    }

}