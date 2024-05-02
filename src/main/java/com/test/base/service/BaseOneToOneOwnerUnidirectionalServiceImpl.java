package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseOneToOneOwnerUnidirectional;

import com.test.base.persistence.BaseOneToOneOwnerUnidirectionalPersistence;

public abstract class BaseOneToOneOwnerUnidirectionalServiceImpl<T extends BaseOneToOneOwnerUnidirectional, ID> implements BaseOneToOneOwnerUnidirectionalService<T, ID> {

  @Autowired
  protected BaseOneToOneOwnerUnidirectionalPersistence<T,ID> oneToOneOwnerUnidirectionalPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return oneToOneOwnerUnidirectionalPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    oneToOneOwnerUnidirectionalPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return oneToOneOwnerUnidirectionalPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = oneToOneOwnerUnidirectionalPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return oneToOneOwnerUnidirectionalPersistence.save(entity);
  }
}