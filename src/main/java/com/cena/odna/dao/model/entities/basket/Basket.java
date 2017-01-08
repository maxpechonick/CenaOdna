package com.cena.odna.dao.model.entities.basket;

import com.cena.odna.dao.model.core.ModelObject;
import com.cena.odna.dao.model.entities.product.Product;
import com.cena.odna.dao.model.entities.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Admin on 08.01.2017.
 */
@Entity
@Table(name = "BASKET")
public class Basket implements ModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basket_seq")
    @SequenceGenerator(name = "basket_seq", sequenceName = "BASKET_SEQ",
            allocationSize = 1)
    private Long id;

    @JoinColumn(name = "USER_ID", nullable = false)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private User user;

    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Product product;

    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
