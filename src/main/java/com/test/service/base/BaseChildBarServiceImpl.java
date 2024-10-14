package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseChildBar;
import com.test.model.ChildBar;

import com.test.service.ServiceException;

import com.test.persistence.ChildBarPersistence;
import com.test.persistence.base.BaseChildBarPersistence;

public abstract class BaseChildBarServiceImpl<T extends ChildBar, ID> implements BaseChildBarService<T, ID> {

  @Autowired
  private BaseChildBarPersistence<T,ID> baseChildBarPersistence;
  
  @Autowired
  protected ChildBarPersistence childBarPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseChildBarPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseChildBarPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseChildBarPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseChildBarPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseChildBarPersistence.save(entity);
  }
}