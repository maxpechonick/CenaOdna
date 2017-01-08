package com.cena.odna.core.mvc.service.basket;

import com.cena.odna.core.mvc.service.core.GenericService;
import com.cena.odna.dto.basket.BasketDTO;

import java.util.List;

/**
 * Created by Admin on 08.01.2017.
 */
public interface BasketService extends GenericService<BasketDTO> {

    public List<BasketDTO> getAllByUser(Long userId);

}
