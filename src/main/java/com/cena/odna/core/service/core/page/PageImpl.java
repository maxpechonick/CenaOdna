package com.cena.odna.core.service.core.page;

import com.cena.odna.core.service.exceptions.ServiceException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 31.12.2016.
 */
public class PageImpl<T> implements Page<T>, Serializable{

    private static final long serialVersionUID = 2907199729L;

    private final List<T> content = new ArrayList<T>();
    private final Pageable pageable;
    private final long total;

    public PageImpl(List<T> content, Pageable pageable, long total) {
        if (content == null) {
            throw new ServiceException("Content must not be null!");
        }
        this.content.addAll(content);
        this.pageable = pageable;
        this.total = !content.isEmpty() && pageable != null && pageable.getOffset() + pageable.getPageSize() > total
                ? pageable.getOffset() + content.size() : total;
    }

    public PageImpl(List<T> content) {
        this(content, null, null == content ? 0 : content.size());
    }

    @Override
    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    @Override
    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    @Override
    public int getSize() {
        return pageable == null ? 0 : pageable.getPageSize();
    }

    @Override
    public int getNumber() {
        return pageable == null ? 0 : pageable.getPageNumber();
    }

    @Override
    public Pageable nextPageable() {
        return hasNext() ? pageable.next() : null;
    }

    @Override
    public Pageable previousPageable() {
        return hasPrevious() ? pageable.previous() : null;
    }

    @Override
    public boolean hasContent() {
        return !content.isEmpty();
    }

    @Override
    public boolean isFirst() {
        return !hasPrevious();
    }

    @Override
    public boolean isLast() {
        return !hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return getNumber() > 0;
    }

    @Override
    public boolean hasNext() {
        return getNumber() + 1 < getTotalPages();
    }

    @Override
    public int getNumberOfElements() {
        return content.size();
    }

    @Override
    public Iterator<T> iterator() {
        return content.iterator();
    }

    @Override
    public long getTotalElements() {
        return total;
    }
}
