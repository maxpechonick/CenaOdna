package com.cena.odna.dao.repository.basket;

import com.cena.odna.dao.model.entities.basket.Basket;
import com.cena.odna.dao.model.entities.basket.QBasket;
import com.cena.odna.dao.repository.core.GenericDAOImpl;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 08.01.2017.
 */
@Repository
public class BasketManagerImpl extends GenericDAOImpl<Basket> implements BasketManager {

    @Override
    protected Class<Basket> getModelClass() {
        return Basket.class;
    }

    @Override
    public List<Basket> getAllByUser(Long userId) {
        QBasket basket = QBasket.basket;
        JPAQuery query = new JPAQuery(entityManager);
        query.from(basket).where(basket.user().id.eq(userId));
        return query.list(basket);
    }
}
