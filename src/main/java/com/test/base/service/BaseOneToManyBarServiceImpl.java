package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseOneToManyBar;

import com.test.base.persistence.BaseOneToManyBarPersistence;

public abstract class BaseOneToManyBarServiceImpl<T extends BaseOneToManyBar, ID> implements BaseOneToManyBarService<T, ID> {

  @Autowired
  protected BaseOneToManyBarPersistence<T,ID> oneToManyBarPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return oneToManyBarPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    oneToManyBarPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return oneToManyBarPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = oneToManyBarPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return oneToManyBarPersistence.save(entity);
  }
}