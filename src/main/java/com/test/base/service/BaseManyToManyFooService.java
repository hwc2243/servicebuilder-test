package com.test.base.service;

import com.test.base.model.BaseManyToManyFoo;

public interface BaseManyToManyFooService<T extends BaseManyToManyFoo, ID> extends EntityService<T, ID> {
}