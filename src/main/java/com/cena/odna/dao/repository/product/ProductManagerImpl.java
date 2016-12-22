package com.cena.odna.dao.repository.product;

import com.cena.odna.dao.model.entities.product.Product;
import com.cena.odna.dao.model.entities.product.QProduct;
import com.cena.odna.dao.repository.core.GenericDAOImpl;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 12.12.2016.
 */
@Repository
public class ProductManagerImpl extends GenericDAOImpl<Product, Long> implements ProductManager{

    protected Class<Product> getClazz() {
        return Product.class;
    }

    public List<Product> getAllForCategory(Long categoryId) {
        QProduct product = QProduct.product;
        JPAQuery query = new JPAQuery(entityManager);
        query.from(product).where(product.category().id.eq(categoryId));
        return query.list(product);
    }
}
