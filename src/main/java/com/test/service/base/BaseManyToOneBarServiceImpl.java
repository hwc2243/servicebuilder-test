package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseManyToOneBar;
import com.test.model.ManyToOneBar;

import com.test.service.ServiceException;

import com.test.persistence.ManyToOneBarPersistence;
import com.test.persistence.base.BaseManyToOneBarPersistence;

public abstract class BaseManyToOneBarServiceImpl<T extends ManyToOneBar, ID> implements BaseManyToOneBarService<T, ID> {

  @Autowired
  private BaseManyToOneBarPersistence<T,ID> baseManyToOneBarPersistence;
  
  @Autowired
  protected ManyToOneBarPersistence manyToOneBarPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseManyToOneBarPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseManyToOneBarPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseManyToOneBarPersistence.findAll();
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseManyToOneBarPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseManyToOneBarPersistence.save(entity);
  }
}