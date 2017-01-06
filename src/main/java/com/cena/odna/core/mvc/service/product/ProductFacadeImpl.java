package com.cena.odna.core.mvc.service.product;

import com.cena.odna.core.mvc.service.category.CategoryFacade;
import com.cena.odna.core.mvc.service.core.GenericFacadeImpl;
import com.cena.odna.core.mvc.service.user.UserFacade;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.entities.product.Product;
import com.cena.odna.dao.repository.product.ProductManager;
import com.cena.odna.dto.product.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 30.12.2016.
 */
@Service
@Transactional
public class ProductFacadeImpl extends GenericFacadeImpl<ProductManager, ProductDTO, Product> implements ProductFacade {

    @Autowired
    private ProductManager manager;

    @Autowired
    private CategoryFacade categoryFacade;

    @Autowired
    private UserFacade userFacade;

    private static final Logger logger = LoggerFactory.getLogger(ProductFacadeImpl.class);

    @Override
    protected ProductManager getDAO() {
        return manager;
    }

    @Override
    public Product convertToModel(ProductDTO dto) {
        Product result = new Product();
        if (dto == null) {
            return result;
        }
        result.setDescription(dto.getDescription());
        result.setId(dto.getId());
        result.setHeight(dto.getHeight());
        result.setLength(dto.getLength());
        result.setQuantity(dto.getQuantity());
        result.setWidth(dto.getWidth());
        try {
            result.setCategory(categoryFacade.convertToModel(categoryFacade.findByPK(dto.getCategory().getId())));
        } catch (ManagerException e) {
            logger.error("error in ProductFacadeImpl.convertToModel");
        }
        //todo users
        return result;
    }

    @Override
    public ProductDTO convertToDTO(Product product) {
        ProductDTO result = new ProductDTO();
        if (product == null) {
            return result;
        }
        result.setWidth(product.getWidth());
        result.setQuantity(product.getQuantity());
        result.setLength(product.getLength());
        result.setHeight(product.getHeight());
        result.setDescription(product.getDescription());
        result.setId(product.getId());
        result.setCategory(categoryFacade.convertToDTO(product.getCategory()));
        return result;
    }

    @Override
    public List<ProductDTO> getAllForCategory(Long categoryId) {
        return convertToDTOList(manager.getAllForCategory(categoryId));
    }
}
