package ru.gb.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "Order.findById",
        query = "select o from Order o where o.id = :id")
})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name = "products_orders",
            joinColumns = @JoinColumn(name = "orders_id" ),
            inverseJoinColumns = @JoinColumn(name = "product_id"))

    private List<Product> productList;

    @Column(name = "products")
    private String products;

    @Column(name = "cost")
    private BigDecimal cost;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", products=" + products +
                ", cost=" + cost +
                "}\n";
    }

}
