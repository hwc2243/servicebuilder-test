package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.ManyToOneBar;

import com.test.api.base.internal.BaseInternalManyToOneBarRest;

public interface BaseInternalManyToOneBarRest
{
	public ResponseEntity<ManyToOneBar> getManyToOneBarById (Long id);

}