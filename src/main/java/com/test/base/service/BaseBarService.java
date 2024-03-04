package com.test.base.service;

import com.test.base.model.BaseBar;

public interface BaseBarService<T extends BaseBar, ID> extends EntityService<T, ID> {
}