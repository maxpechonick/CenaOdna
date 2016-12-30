package com.cena.odna.core.service.category;

import com.cena.odna.core.service.core.GenericFacadeImpl;
import com.cena.odna.dao.model.entities.category.Category;
import com.cena.odna.dao.repository.category.CategoryManager;
import com.cena.odna.dao.repository.category.CategoryManagerImpl;
import com.cena.odna.dto.category.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Admin on 30.12.2016.
 */
@Service
@Transactional
public class CategoryFacadeImpl extends GenericFacadeImpl<CategoryManager, CategoryDTO, Category>
        implements CategoryFacade {

    @Autowired
    private CategoryManager manager;

    @Override
    public CategoryManager getDAO() {
        return manager;
    }

    @Override
    public Category convertToModel(CategoryDTO dto) {
        Category result = new Category();
        if (dto == null) {
            return result;
        }
        result.setId(dto.getId());
        result.setImage(dto.getImage());
        result.setName(dto.getName());
        result.setChildCategories(new HashSet<Category>());
        for (CategoryDTO categoryDTO : dto.getChildCategories()) {
            result.getChildCategories().add(convertToModel(categoryDTO));
        }
        return result;
    }

    @Override
    public CategoryDTO convertToDTO(Category category) {
        CategoryDTO result = new CategoryDTO();
        if (category == null) {
            return result;
        }
        result.setName(category.getName());
        result.setId(category.getId());
        result.setImage(category.getImage());
        result.setChildCategories(new ArrayList<CategoryDTO>());
        for (Category child : category.getChildCategories()) {
            result.getChildCategories().add(convertToDTO(child));
        }
        return result;
    }
}
