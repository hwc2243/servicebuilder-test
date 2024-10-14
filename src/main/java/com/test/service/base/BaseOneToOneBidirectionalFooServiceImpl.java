package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseOneToOneBidirectionalFoo;
import com.test.model.OneToOneBidirectionalFoo;

import com.test.service.ServiceException;

import com.test.persistence.OneToOneBidirectionalFooPersistence;
import com.test.persistence.base.BaseOneToOneBidirectionalFooPersistence;

public abstract class BaseOneToOneBidirectionalFooServiceImpl<T extends OneToOneBidirectionalFoo, ID> implements BaseOneToOneBidirectionalFooService<T, ID> {

  @Autowired
  private BaseOneToOneBidirectionalFooPersistence<T,ID> baseOneToOneBidirectionalFooPersistence;
  
  @Autowired
  protected OneToOneBidirectionalFooPersistence oneToOneBidirectionalFooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseOneToOneBidirectionalFooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseOneToOneBidirectionalFooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseOneToOneBidirectionalFooPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseOneToOneBidirectionalFooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseOneToOneBidirectionalFooPersistence.save(entity);
  }
}