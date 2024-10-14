package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseFoo;
import com.test.model.Foo;

public interface BaseFooPersistence<T extends Foo, ID> extends JpaRepository<T, ID>
{

	public List<T> findByA (long a);

	public List<T> findByAAndB (long a, String b);
} 