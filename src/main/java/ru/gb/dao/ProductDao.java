package ru.gb.dao;

import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    BigDecimal totalCost(List<Product> productList);
}
