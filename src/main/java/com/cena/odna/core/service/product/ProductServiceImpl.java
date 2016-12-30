package com.cena.odna.core.service.product;

import com.cena.odna.core.service.core.GenericServiceImpl;
import com.cena.odna.dto.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 21.12.2016.
 */
@Service
public class ProductServiceImpl extends GenericServiceImpl<ProductFacadeImpl, ProductDTO> implements ProductService {

    @Autowired
    private ProductFacadeImpl facade;

    @Override
    protected ProductFacadeImpl getFacade() {
        return facade;
    }

    @Override
    public List<ProductDTO> getAllForCategory(Long categoryId) {
        return facade.getAllForCategory(categoryId);
    }
}
