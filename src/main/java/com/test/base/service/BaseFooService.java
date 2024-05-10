package com.test.base.service;

import com.test.base.model.BaseFoo;

public interface BaseFooService<T extends BaseFoo, ID> extends EntityService<T, ID> {
}