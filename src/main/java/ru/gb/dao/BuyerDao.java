package ru.gb.dao;

import ru.gb.entity.Buyer;

public interface BuyerDao {
    Iterable<Buyer> findAll();
    Buyer findById(Long id);
}
