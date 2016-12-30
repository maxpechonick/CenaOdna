package com.cena.odna.dao.repository.product;


import com.cena.odna.dao.repository.core.GenericDAO;
import com.cena.odna.dao.model.entities.product.Product;

import java.util.List;

/**
 * Created by Admin on 12.12.2016.
 */
public interface ProductManager extends GenericDAO<Product> {

    List<Product> getAllForCategory(Long categoryId);

}
