package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class JpaProductDao implements ProductDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findById", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Product save(Product product) {
//        if (product.getId() == null) {
//            entityManager.persist(product);
//        } else {
            entityManager.merge(product);
//        }
        return product;
    }

    @Override
    public BigDecimal totalCost(List<Product> productList) {
        final BigDecimal  lastCost=BigDecimal.valueOf(productList.stream().mapToDouble(c->(c.getCost()).doubleValue()).sum());
        return lastCost;
    }
}
