package com.cena.odna.dto.basket;

import com.cena.odna.dto.core.AbstractDTO;
import com.cena.odna.dto.product.ProductDTO;

/**
 * Created by Admin on 08.01.2017.
 */
public class BasketDTO extends AbstractDTO {

    private ProductDTO product;

    private Long quantity;

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
