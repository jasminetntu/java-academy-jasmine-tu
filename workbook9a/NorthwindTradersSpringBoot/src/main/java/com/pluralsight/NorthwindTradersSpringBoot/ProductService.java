package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final JdbcProductDao jdbcProductDao;

    @Autowired
    public ProductService(JdbcProductDao jdbcProductDao) {
        this.jdbcProductDao = jdbcProductDao;
    }

    private void listProducts() {
        for (Product p : jdbcProductDao.getAll()) {
            System.out.println(p);
        }
    }

    private void addProduct(Product product) {
        jdbcProductDao.add(product);
    }

}