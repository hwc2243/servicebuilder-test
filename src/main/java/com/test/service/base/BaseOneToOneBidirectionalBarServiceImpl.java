package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseOneToOneBidirectionalBar;
import com.test.model.OneToOneBidirectionalBar;

import com.test.service.ServiceException;

import com.test.persistence.OneToOneBidirectionalBarPersistence;
import com.test.persistence.base.BaseOneToOneBidirectionalBarPersistence;

public abstract class BaseOneToOneBidirectionalBarServiceImpl<T extends OneToOneBidirectionalBar, ID> implements BaseOneToOneBidirectionalBarService<T, ID> {

  @Autowired
  private BaseOneToOneBidirectionalBarPersistence<T,ID> baseOneToOneBidirectionalBarPersistence;
  
  @Autowired
  protected OneToOneBidirectionalBarPersistence oneToOneBidirectionalBarPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseOneToOneBidirectionalBarPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseOneToOneBidirectionalBarPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseOneToOneBidirectionalBarPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseOneToOneBidirectionalBarPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseOneToOneBidirectionalBarPersistence.save(entity);
  }
}