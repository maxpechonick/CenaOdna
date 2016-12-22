package com.cena.odna.core.service.category;

import com.cena.odna.core.service.core.GenericService;
import com.cena.odna.dao.model.entities.category.Category;
import com.cena.odna.dao.repository.category.CategoryManager;

/**
 * Created by Admin on 21.12.2016.
 */
public interface CategoryService extends GenericService<CategoryManager, Category, Long> {
}
