package com.cena.odna.core.service.category;

import com.cena.odna.core.service.core.GenericServiceImpl;
import com.cena.odna.dao.model.entities.category.Category;
import com.cena.odna.dao.repository.category.CategoryManager;
import com.cena.odna.dto.category.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Admin on 21.12.2016.
 */
@Service
public class CategoryServiceImpl extends GenericServiceImpl<CategoryFacade, CategoryDTO>
        implements CategoryService{

    @Autowired
    private CategoryFacade facade;

    @Override
    protected CategoryFacade getFacade() {
        return facade;
    }
}
