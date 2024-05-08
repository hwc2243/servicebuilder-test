package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseManyToManyFoo;

import com.test.base.persistence.BaseManyToManyFooPersistence;

public abstract class BaseManyToManyFooServiceImpl<T extends BaseManyToManyFoo, ID> implements BaseManyToManyFooService<T, ID> {

  @Autowired
  protected BaseManyToManyFooPersistence<T,ID> manyToManyFooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return manyToManyFooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    manyToManyFooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return manyToManyFooPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = manyToManyFooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return manyToManyFooPersistence.save(entity);
  }
}