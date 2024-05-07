package com.test.base.service;

import java.util.List;

import com.test.base.model.BaseManyToOneFoo;

public interface BaseManyToOneFooService<T extends BaseManyToOneFoo, ID> extends EntityService<T, ID> {

	public List<T> findByA (long a);

	public List<T> findByAAndB (long a, String b);
}