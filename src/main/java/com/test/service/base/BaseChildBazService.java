package com.test.service.base;

import java.util.List;

import com.test.model.base.BaseChildBaz;

public interface BaseChildBazService<T extends BaseChildBaz, ID> extends EntityService<T, ID> {
}