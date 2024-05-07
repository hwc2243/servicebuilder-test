package com.test.base.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseManyToOneFoo;

public interface BaseManyToOneFooPersistence<T extends BaseManyToOneFoo, ID> extends JpaRepository<T, ID>
{

	public List<T> findByA (long a);

	public List<T> findByAAndB (long a, String b);
} 