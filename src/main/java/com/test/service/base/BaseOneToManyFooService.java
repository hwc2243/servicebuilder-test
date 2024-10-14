package com.test.service.base;

import java.util.List;

import com.test.model.base.BaseOneToManyFoo;

public interface BaseOneToManyFooService<T extends BaseOneToManyFoo, ID> extends EntityService<T, ID> {
}