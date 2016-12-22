package com.cena.odna.core.service.product;

import com.cena.odna.core.service.core.GenericServiceImpl;
import com.cena.odna.dao.model.entities.product.Product;
import com.cena.odna.dao.repository.product.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 21.12.2016.
 */
@Service
@Transactional
public class ProductServiceImpl extends GenericServiceImpl<ProductManager, Product, Long> implements ProductService{

    @Autowired
    private ProductManager productManager;

    protected ProductManager getDAO() {
        return productManager;
    }

    public List<Product> getAllForCategory(Long categoryId) {
        return productManager.getAllForCategory(categoryId);
    }
}
