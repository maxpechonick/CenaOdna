package com.cena.odna.core.mvc.service.basket;

import com.cena.odna.core.mvc.service.core.GenericFacade;
import com.cena.odna.dao.model.entities.basket.Basket;
import com.cena.odna.dto.basket.BasketDTO;

import java.util.List;

/**
 * Created by Admin on 08.01.2017.
 */
public interface BasketFacade extends GenericFacade<BasketDTO, Basket> {
    List<BasketDTO> findAllByUser(Long userId);
}
