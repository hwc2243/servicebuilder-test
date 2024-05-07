package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseOneToOneBidirectionalFoo;

import com.test.base.persistence.BaseOneToOneBidirectionalFooPersistence;

public abstract class BaseOneToOneBidirectionalFooServiceImpl<T extends BaseOneToOneBidirectionalFoo, ID> implements BaseOneToOneBidirectionalFooService<T, ID> {

  @Autowired
  protected BaseOneToOneBidirectionalFooPersistence<T,ID> oneToOneBidirectionalFooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return oneToOneBidirectionalFooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    oneToOneBidirectionalFooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return oneToOneBidirectionalFooPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = oneToOneBidirectionalFooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return oneToOneBidirectionalFooPersistence.save(entity);
  }
}