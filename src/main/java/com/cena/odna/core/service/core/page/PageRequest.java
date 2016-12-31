package com.cena.odna.core.service.core.page;

import com.cena.odna.core.service.exceptions.ServiceException;

/**
 * Created by Admin on 31.12.2016.
 */
public class PageRequest implements Pageable {

    private final int size;
    private final int page;

    public PageRequest(int size, int page) {
        if (size < 1) {
            throw new ServiceException("size must be 1 or more!");
        }
        this.size = size;
        if (page < 0) {
            throw new ServiceException("page must be 0 or more!");
        }
        this.page = page;
    }

    @Override
    public boolean hasPrevious() {
        return page > 0;
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public int getOffset() {
        return page * size;
    }

    @Override
    public int getPageNumber() {
        return page;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    @Override
    public Pageable next() {
        return new PageRequest(getPageSize(), getPageNumber() + 1);
    }

    @Override
    public Pageable previous() {
        return new PageRequest(getPageSize(), getPageNumber() - 1);
    }

    @Override
    public Pageable first() {
        return new PageRequest(getPageSize(), 0);
    }
}
