package com.cena.odna.core.mvc.service.basket;

import com.cena.odna.core.mvc.service.core.GenericFacadeImpl;
import com.cena.odna.core.mvc.service.product.ProductFacade;
import com.cena.odna.dao.model.entities.basket.Basket;
import com.cena.odna.dao.repository.basket.BasketManager;
import com.cena.odna.dto.basket.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 08.01.2017.
 */
@Service
@Transactional
public class BasketFacadeImpl extends GenericFacadeImpl<BasketManager, BasketDTO, Basket> implements BasketFacade {

    @Autowired
    private BasketManager manager;

    @Autowired
    private ProductFacade productFacade;

    @Override
    protected BasketManager getDAO() {
        return manager;
    }

    @Override
    public Basket convertToModel(BasketDTO dto) {
        Basket result = new Basket();
        result.setId(dto.getId());
        result.setQuantity(dto.getQuantity());
        result.setProduct(productFacade.convertToModel(dto.getProduct()));
        //todo user;
        return result;
    }

    @Override
    public BasketDTO convertToDTO(Basket basket) {
        BasketDTO result = new BasketDTO();
        result.setId(basket.getId());
        result.setProduct(productFacade.convertToDTO(basket.getProduct()));
        result.setQuantity(basket.getQuantity());
        return result;
    }

    @Override
    public List<BasketDTO> findAllByUser(Long userId) {
        return convertToDTOList(getDAO().getAllByUser(userId));
    }
}
