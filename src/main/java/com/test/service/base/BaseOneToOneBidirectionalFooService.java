package com.test.service.base;

import java.util.List;

import com.test.model.base.BaseOneToOneBidirectionalFoo;

public interface BaseOneToOneBidirectionalFooService<T extends BaseOneToOneBidirectionalFoo, ID> extends EntityService<T, ID> {
}