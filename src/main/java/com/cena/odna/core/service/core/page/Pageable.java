package com.cena.odna.core.service.core.page;

import java.io.Serializable;

/**
 * Created by Admin on 31.12.2016.
 */
public interface Pageable extends Serializable {

    boolean hasPrevious();
    Pageable previousOrFirst();
    int getOffset();
    int getPageNumber();
    int getPageSize();
    Pageable next();
    Pageable previous();
    Pageable first();

}
