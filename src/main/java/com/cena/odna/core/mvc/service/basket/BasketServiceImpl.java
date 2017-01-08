package com.cena.odna.core.mvc.service.basket;

import com.cena.odna.core.mvc.service.core.GenericServiceImpl;
import com.cena.odna.dto.basket.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 08.01.2017.
 */
@Service
public class BasketServiceImpl extends GenericServiceImpl<BasketFacade, BasketDTO> implements BasketService {

    @Autowired
    private BasketFacade facade;

    @Override
    protected BasketFacade getFacade() {
        return facade;
    }

    @Override
    public List<BasketDTO> getAllByUser(Long userId) {
        return getFacade().findAllByUser(userId);
    }
}
