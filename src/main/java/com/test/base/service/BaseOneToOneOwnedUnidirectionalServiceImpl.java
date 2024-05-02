package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseOneToOneOwnedUnidirectional;

import com.test.base.persistence.BaseOneToOneOwnedUnidirectionalPersistence;

public abstract class BaseOneToOneOwnedUnidirectionalServiceImpl<T extends BaseOneToOneOwnedUnidirectional, ID> implements BaseOneToOneOwnedUnidirectionalService<T, ID> {

  @Autowired
  protected BaseOneToOneOwnedUnidirectionalPersistence<T,ID> oneToOneOwnedUnidirectionalPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return oneToOneOwnedUnidirectionalPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    oneToOneOwnedUnidirectionalPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return oneToOneOwnedUnidirectionalPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = oneToOneOwnedUnidirectionalPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return oneToOneOwnedUnidirectionalPersistence.save(entity);
  }
}