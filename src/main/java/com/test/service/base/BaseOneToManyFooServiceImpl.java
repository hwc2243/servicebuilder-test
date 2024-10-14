package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseOneToManyFoo;
import com.test.model.OneToManyFoo;

import com.test.service.ServiceException;

import com.test.persistence.OneToManyFooPersistence;
import com.test.persistence.base.BaseOneToManyFooPersistence;

public abstract class BaseOneToManyFooServiceImpl<T extends OneToManyFoo, ID> implements BaseOneToManyFooService<T, ID> {

  @Autowired
  private BaseOneToManyFooPersistence<T,ID> baseOneToManyFooPersistence;
  
  @Autowired
  protected OneToManyFooPersistence oneToManyFooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseOneToManyFooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseOneToManyFooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseOneToManyFooPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseOneToManyFooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseOneToManyFooPersistence.save(entity);
  }
}