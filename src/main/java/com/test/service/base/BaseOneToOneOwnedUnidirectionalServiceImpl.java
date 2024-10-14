package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseOneToOneOwnedUnidirectional;
import com.test.model.OneToOneOwnedUnidirectional;

import com.test.service.ServiceException;

import com.test.persistence.OneToOneOwnedUnidirectionalPersistence;
import com.test.persistence.base.BaseOneToOneOwnedUnidirectionalPersistence;

public abstract class BaseOneToOneOwnedUnidirectionalServiceImpl<T extends OneToOneOwnedUnidirectional, ID> implements BaseOneToOneOwnedUnidirectionalService<T, ID> {

  @Autowired
  private BaseOneToOneOwnedUnidirectionalPersistence<T,ID> baseOneToOneOwnedUnidirectionalPersistence;
  
  @Autowired
  protected OneToOneOwnedUnidirectionalPersistence oneToOneOwnedUnidirectionalPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseOneToOneOwnedUnidirectionalPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseOneToOneOwnedUnidirectionalPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseOneToOneOwnedUnidirectionalPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseOneToOneOwnedUnidirectionalPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseOneToOneOwnedUnidirectionalPersistence.save(entity);
  }
}