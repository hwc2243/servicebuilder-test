package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseFoo;

import com.test.base.persistence.BaseFooPersistence;

public abstract class BaseFooServiceImpl<T extends BaseFoo, ID> implements BaseFooService<T, ID> {

  @Autowired
  protected BaseFooPersistence<T,ID> fooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return fooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    fooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return fooPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = fooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return fooPersistence.save(entity);
  }
}