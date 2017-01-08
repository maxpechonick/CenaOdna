package com.cena.odna.dao.repository.basket;

import com.cena.odna.dao.model.entities.basket.Basket;
import com.cena.odna.dao.repository.core.GenericDAOImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 08.01.2017.
 */
@Repository
public class BasketManagerImpl extends GenericDAOImpl<Basket> implements BasketManager {

    @Override
    protected Class<Basket> getModelClass() {
        return Basket.class;
    }

}
