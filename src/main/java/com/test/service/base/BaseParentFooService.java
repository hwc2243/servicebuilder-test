package com.test.service.base;

import java.util.List;

import com.test.model.base.BaseParentFoo;

public interface BaseParentFooService<T extends BaseParentFoo, ID> extends EntityService<T, ID> {
}