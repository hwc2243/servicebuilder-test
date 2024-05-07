package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseManyToOneFoo;

import com.test.base.persistence.BaseManyToOneFooPersistence;

public abstract class BaseManyToOneFooServiceImpl<T extends BaseManyToOneFoo, ID> implements BaseManyToOneFooService<T, ID> {

  @Autowired
  protected BaseManyToOneFooPersistence<T,ID> manyToOneFooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return manyToOneFooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    manyToOneFooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return manyToOneFooPersistence.findAll();
  }

  @Override
  public List<T> findByA (long a)
  {
	return manyToOneFooPersistence.findByA(a);
  }

  @Override
  public List<T> findByAAndB (long a, String b)
  {
	return manyToOneFooPersistence.findByAAndB(a, b);
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = manyToOneFooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return manyToOneFooPersistence.save(entity);
  }
}