package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseOneToOneOwnerUnidirectional;
import com.test.model.OneToOneOwnerUnidirectional;

import com.test.service.ServiceException;

import com.test.persistence.OneToOneOwnerUnidirectionalPersistence;
import com.test.persistence.base.BaseOneToOneOwnerUnidirectionalPersistence;

public abstract class BaseOneToOneOwnerUnidirectionalServiceImpl<T extends OneToOneOwnerUnidirectional, ID> implements BaseOneToOneOwnerUnidirectionalService<T, ID> {

  @Autowired
  private BaseOneToOneOwnerUnidirectionalPersistence<T,ID> baseOneToOneOwnerUnidirectionalPersistence;
  
  @Autowired
  protected OneToOneOwnerUnidirectionalPersistence oneToOneOwnerUnidirectionalPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseOneToOneOwnerUnidirectionalPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseOneToOneOwnerUnidirectionalPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseOneToOneOwnerUnidirectionalPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseOneToOneOwnerUnidirectionalPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseOneToOneOwnerUnidirectionalPersistence.save(entity);
  }
}