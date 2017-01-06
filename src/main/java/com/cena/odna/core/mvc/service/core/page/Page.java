package com.cena.odna.core.mvc.service.core.page;

import java.util.List;

/**
 * Created by Admin on 31.12.2016.
 */
public interface Page<T> extends Iterable<T> {

    int getTotalPages();
    List<T> getContent();
    int getSize();
    int getNumber();
    Pageable nextPageable();
    Pageable previousPageable();
    boolean hasContent();
    boolean isFirst();
    boolean isLast();
    boolean hasPrevious();
    boolean hasNext();
    int getNumberOfElements();
    long getTotalElements();

}
