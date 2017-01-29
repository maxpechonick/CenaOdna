package com.cena.odna.dto.product;

import com.cena.odna.dto.category.CategoryDTO;
import com.cena.odna.dto.core.AbstractDTO;

/**
 * Created by Admin on 22.12.2016.
 */
public class ProductDTO extends AbstractDTO {

    private String description;
    private Integer length;
    private Integer height;
    private Integer width;
    private Integer quantity;
    private CategoryDTO category;
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
