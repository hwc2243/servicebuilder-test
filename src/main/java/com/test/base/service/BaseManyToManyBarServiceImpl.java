package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseManyToManyBar;

import com.test.base.persistence.BaseManyToManyBarPersistence;

public abstract class BaseManyToManyBarServiceImpl<T extends BaseManyToManyBar, ID> implements BaseManyToManyBarService<T, ID> {

  @Autowired
  protected BaseManyToManyBarPersistence<T,ID> manyToManyBarPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return manyToManyBarPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    manyToManyBarPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return manyToManyBarPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = manyToManyBarPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return manyToManyBarPersistence.save(entity);
  }
}