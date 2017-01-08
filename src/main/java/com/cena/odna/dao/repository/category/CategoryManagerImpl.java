package com.cena.odna.dao.repository.category;

import com.cena.odna.dao.repository.core.GenericDAOImpl;
import com.cena.odna.dao.model.entities.category.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 12.12.2016.
 */
@Repository
public class CategoryManagerImpl extends GenericDAOImpl<Category> implements CategoryManager {
    protected Class<Category> getModelClass() {
        return Category.class;
    }
}
