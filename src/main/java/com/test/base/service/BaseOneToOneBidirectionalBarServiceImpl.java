package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseOneToOneBidirectionalBar;

import com.test.base.persistence.BaseOneToOneBidirectionalBarPersistence;

public abstract class BaseOneToOneBidirectionalBarServiceImpl<T extends BaseOneToOneBidirectionalBar, ID> implements BaseOneToOneBidirectionalBarService<T, ID> {

  @Autowired
  protected BaseOneToOneBidirectionalBarPersistence<T,ID> oneToOneBidirectionalBarPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return oneToOneBidirectionalBarPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    oneToOneBidirectionalBarPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return oneToOneBidirectionalBarPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = oneToOneBidirectionalBarPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return oneToOneBidirectionalBarPersistence.save(entity);
  }
}