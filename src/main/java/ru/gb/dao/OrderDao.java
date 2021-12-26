package ru.gb.dao;

import ru.gb.entity.Order;
import ru.gb.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDao {

    List<Order> findAll();
    Order findByIdInf(Long id);
    Order save (Order order);
    public BigDecimal finalAmount(List<Product> productList);


}