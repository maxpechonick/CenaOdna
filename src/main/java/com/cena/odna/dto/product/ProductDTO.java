package com.cena.odna.dto.product;

import com.cena.odna.dto.category.CategoryDTO;
import com.cena.odna.dto.core.AbstractDTO;

/**
 * Created by Admin on 22.12.2016.
 */
public class ProductDTO extends AbstractDTO {

    private String description;
    private int length;
    private int height;
    private int width;
    private int quantity;
    private CategoryDTO category;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
