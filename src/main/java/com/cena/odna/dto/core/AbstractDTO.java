package com.cena.odna.dto.core;

/**
 * Created by Admin on 30.12.2016.
 */
public abstract class AbstractDTO {

    Long rid;

    public Long getId() {
        return rid;
    }

    public void setId(Long rid) {
        this.rid = rid;
    }
}
