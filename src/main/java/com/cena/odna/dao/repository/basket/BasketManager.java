package com.cena.odna.dao.repository.basket;

import com.cena.odna.dao.model.entities.basket.Basket;
import com.cena.odna.dao.repository.core.GenericDAO;

import java.util.List;

/**
 * Created by Admin on 08.01.2017.
 */
public interface BasketManager extends GenericDAO<Basket> {

    public List<Basket> getAllByUser(Long userId);

}
