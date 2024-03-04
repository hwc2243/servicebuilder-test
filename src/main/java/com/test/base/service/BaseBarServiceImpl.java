package com.test.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.base.model.BaseBar;

import com.test.base.persistence.BaseBarPersistence;

public abstract class BaseBarServiceImpl<T extends BaseBar, ID> implements BaseBarService<T, ID> {

  @Autowired
  protected BaseBarPersistence<T,ID> barPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return barPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    barPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return barPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = barPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return barPersistence.save(entity);
  }
}