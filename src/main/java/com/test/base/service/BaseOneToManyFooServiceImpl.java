package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseOneToManyFoo;

import com.test.base.persistence.BaseOneToManyFooPersistence;

public abstract class BaseOneToManyFooServiceImpl<T extends BaseOneToManyFoo, ID> implements BaseOneToManyFooService<T, ID> {

  @Autowired
  protected BaseOneToManyFooPersistence<T,ID> oneToManyFooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return oneToManyFooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    oneToManyFooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return oneToManyFooPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = oneToManyFooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return oneToManyFooPersistence.save(entity);
  }
}