package com.test.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.model.base.BaseManyToOneFoo;
import com.test.model.ManyToOneFoo;

import com.test.service.ServiceException;

import com.test.persistence.ManyToOneFooPersistence;
import com.test.persistence.base.BaseManyToOneFooPersistence;

public abstract class BaseManyToOneFooServiceImpl<T extends ManyToOneFoo, ID> implements BaseManyToOneFooService<T, ID> {

  @Autowired
  private BaseManyToOneFooPersistence<T,ID> baseManyToOneFooPersistence;
  
  @Autowired
  protected ManyToOneFooPersistence manyToOneFooPersistence;
  
  @Override
  public T create (T entity) throws ServiceException
  {
    return baseManyToOneFooPersistence.save(entity);
  }
  
  @Override
  public void delete (ID id) throws ServiceException
  {
    baseManyToOneFooPersistence.deleteById(id);
  }
  
  @Override
  public List<T> findAll () throws ServiceException
  {
    return baseManyToOneFooPersistence.findAll();
  }

  @Override
  public List<T> findByA (long a)
  {
	return baseManyToOneFooPersistence.findByA(a);
  }

  @Override
  public List<T> findByAAndB (long a, String b)
  {
	return baseManyToOneFooPersistence.findByAAndB(a, b);
  }

  @Override
  public T get (ID id) throws ServiceException
  {
    Optional<T> optional = baseManyToOneFooPersistence.findById(id);

    return optional.isEmpty() ? null : optional.get();
  }
  
  @Override
  public T update (T entity) throws ServiceException
  {
    return baseManyToOneFooPersistence.save(entity);
  }
}