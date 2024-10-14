package com.test.service.base;

import java.util.List;

import com.test.model.base.BaseManyToOneFoo;

public interface BaseManyToOneFooService<T extends BaseManyToOneFoo, ID> extends EntityService<T, ID> {

	public List<T> findByA (long a);

	public List<T> findByAAndB (long a, String b);
}