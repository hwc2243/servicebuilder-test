package com.test.base.service;

import com.test.base.model.BaseOneToOneBidirectionalFoo;

public interface BaseOneToOneBidirectionalFooService<T extends BaseOneToOneBidirectionalFoo, ID> extends EntityService<T, ID> {
}