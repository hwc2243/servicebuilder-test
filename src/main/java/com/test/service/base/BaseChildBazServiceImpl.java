package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseChildBaz;
import com.test.model.ChildBaz;

import com.test.service.ServiceException;

import com.test.persistence.ChildBazPersistence;
import com.test.persistence.base.BaseChildBazPersistence;

public abstract class BaseChildBazServiceImpl<T extends ChildBaz, ID> implements BaseChildBazService<T, ID> {

  @Autowired
  private BaseChildBazPersistence<T,ID> baseChildBazPersistence;
  
  @Autowired
  protected ChildBazPersistence childBazPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseChildBazPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseChildBazPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseChildBazPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseChildBazPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseChildBazPersistence.save(entity);
  }
}