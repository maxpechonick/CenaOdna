package com.cena.odna.dto.category;

import com.cena.odna.dto.core.AbstractDTO;

import java.util.List;

/**
 * Created by Admin on 22.12.2016.
 */
public class CategoryDTO extends AbstractDTO {

    private String name;

    private String image;

    private List<CategoryDTO> childCategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CategoryDTO> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<CategoryDTO> childCategories) {
        this.childCategories = childCategories;
    }
}
