package com.test.service.base;

import com.test.model.base.AbstractBaseEntity;

import com.test.service.ServiceException;

import java.util.List;

public interface EntityService<T extends AbstractBaseEntity, ID> {
	
    public T create(T entity) throws ServiceException;

    public void delete(ID id) throws ServiceException;

    public List<T> findAll () throws ServiceException;
     
    public T get(ID id) throws ServiceException;

    public T update(T entity) throws ServiceException;
}