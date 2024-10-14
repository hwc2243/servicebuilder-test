package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseManyToOneFoo;
import com.test.model.ManyToOneFoo;

public interface BaseManyToOneFooPersistence<T extends ManyToOneFoo, ID> extends JpaRepository<T, ID>
{

	public List<T> findByA (long a);

	public List<T> findByAAndB (long a, String b);
} 