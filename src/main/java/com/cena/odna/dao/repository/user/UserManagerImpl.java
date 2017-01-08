package com.cena.odna.dao.repository.user;

import com.cena.odna.dao.model.entities.user.QUser;
import com.cena.odna.dao.repository.core.GenericDAOImpl;
import com.cena.odna.dao.model.entities.user.User;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.sql.JPASQLQuery;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 12.12.2016.
 */
@Repository
public class UserManagerImpl extends GenericDAOImpl<User> implements UserManager {

    public User findByUserName(String username) {
        QUser user = QUser.user;
        JPAQuery query = new JPAQuery(entityManager);
        query.from(user).where(user.username.eq(username));
        return query.singleResult(user);
    }

    protected Class<User> getModelClass() {
        return User.class;
    }
}
