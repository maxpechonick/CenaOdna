package com.cena.odna.core.mvc.service.product;

import com.cena.odna.core.mvc.service.core.GenericFacade;
import com.cena.odna.dao.model.entities.product.Product;
import com.cena.odna.dto.product.ProductDTO;

import java.util.List;

/**
 * Created by Admin on 30.12.2016.
 */
public interface ProductFacade extends GenericFacade<ProductDTO, Product> {

    List<ProductDTO> getAllForCategory(Long categoryId);

}
