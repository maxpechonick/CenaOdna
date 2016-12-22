package com.cena.odna.dao.model.core;

import java.io.Serializable;

/**
 * Created by Admin on 13.12.2016.
 */
public interface ModelObject<PK> extends Serializable{

    PK getId();

    void setId(PK id);

}
