package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Buyer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class JpaBuyerDao implements BuyerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Buyer> findAll() {
        return entityManager.createQuery("select b from Buyer b").getResultList();
    }

    @Override
    public Buyer findById(Long id) {
        TypedQuery<Buyer> query = entityManager.createNamedQuery("Buyer.findById", Buyer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
