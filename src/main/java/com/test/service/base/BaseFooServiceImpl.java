package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseFoo;
import com.test.model.Foo;

import com.test.service.ServiceException;

import com.test.persistence.FooPersistence;
import com.test.persistence.base.BaseFooPersistence;

public abstract class BaseFooServiceImpl<T extends Foo, ID> implements BaseFooService<T, ID> {

  @Autowired
  private BaseFooPersistence<T,ID> baseFooPersistence;
  
  @Autowired
  protected FooPersistence fooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseFooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseFooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseFooPersistence.findAll();
  }

  @Override
  public List<T> findByA (long a)
  {
	return baseFooPersistence.findByA(a);
  }

  @Override
  public List<T> findByAAndB (long a, String b)
  {
	return baseFooPersistence.findByAAndB(a, b);
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseFooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseFooPersistence.save(entity);
  }
}