package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseManyToOneBar;

import com.test.base.persistence.BaseManyToOneBarPersistence;

public abstract class BaseManyToOneBarServiceImpl<T extends BaseManyToOneBar, ID> implements BaseManyToOneBarService<T, ID> {

  @Autowired
  protected BaseManyToOneBarPersistence<T,ID> manyToOneBarPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return manyToOneBarPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    manyToOneBarPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return manyToOneBarPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = manyToOneBarPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return manyToOneBarPersistence.save(entity);
  }
}