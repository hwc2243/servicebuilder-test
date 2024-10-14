package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseParentFoo;
import com.test.model.ParentFoo;

import com.test.service.ServiceException;

import com.test.persistence.ParentFooPersistence;
import com.test.persistence.base.BaseParentFooPersistence;

public abstract class BaseParentFooServiceImpl<T extends ParentFoo, ID> implements BaseParentFooService<T, ID> {

  @Autowired
  private BaseParentFooPersistence<T,ID> baseParentFooPersistence;
  
  @Autowired
  protected ParentFooPersistence parentFooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseParentFooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseParentFooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseParentFooPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseParentFooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseParentFooPersistence.save(entity);
  }
}