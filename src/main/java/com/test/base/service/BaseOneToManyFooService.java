package com.test.base.service;

import com.test.base.model.BaseOneToManyFoo;

public interface BaseOneToManyFooService<T extends BaseOneToManyFoo, ID> extends EntityService<T, ID> {
}