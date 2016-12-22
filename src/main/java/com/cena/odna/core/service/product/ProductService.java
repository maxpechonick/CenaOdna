package com.cena.odna.core.service.product;

import com.cena.odna.core.service.core.GenericService;
import com.cena.odna.dao.model.entities.product.Product;
import com.cena.odna.dao.repository.product.ProductManager;

import java.util.List;

/**
 * Created by Admin on 21.12.2016.
 */
public interface ProductService extends GenericService<ProductManager, Product, Long> {

    List<Product> getAllForCategory(Long categoryId);

}
