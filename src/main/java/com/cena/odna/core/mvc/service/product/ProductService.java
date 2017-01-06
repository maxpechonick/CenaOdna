package com.cena.odna.core.mvc.service.product;

import com.cena.odna.core.mvc.service.core.GenericService;
import com.cena.odna.dto.product.ProductDTO;

import java.util.List;

/**
 * Created by Admin on 21.12.2016.
 */
public interface ProductService extends GenericService<ProductDTO> {

    List<ProductDTO> getAllForCategory(Long categoryId);

}
