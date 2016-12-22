package com.cena.odna.core.service.category;

import com.cena.odna.core.service.core.GenericServiceImpl;
import com.cena.odna.dao.model.entities.category.Category;
import com.cena.odna.dao.repository.category.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Admin on 21.12.2016.
 */
@Service
@Transactional
public class CategoryServiceImpl extends GenericServiceImpl<CategoryManager, Category, Long>
        implements CategoryService{

    @Autowired
    private CategoryManager categoryManager;

    protected CategoryManager getDAO() {
        return categoryManager;
    }

}
