package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseOneToManyBar;
import com.test.model.OneToManyBar;

import com.test.service.ServiceException;

import com.test.persistence.OneToManyBarPersistence;
import com.test.persistence.base.BaseOneToManyBarPersistence;

public abstract class BaseOneToManyBarServiceImpl<T extends OneToManyBar, ID> implements BaseOneToManyBarService<T, ID> {

  @Autowired
  private BaseOneToManyBarPersistence<T,ID> baseOneToManyBarPersistence;
  
  @Autowired
  protected OneToManyBarPersistence oneToManyBarPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseOneToManyBarPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseOneToManyBarPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseOneToManyBarPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseOneToManyBarPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseOneToManyBarPersistence.save(entity);
  }
}