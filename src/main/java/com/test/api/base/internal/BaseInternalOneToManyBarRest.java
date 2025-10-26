package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.OneToManyBar;

import com.test.api.base.internal.BaseInternalOneToManyBarRest;

public interface BaseInternalOneToManyBarRest
{
	public ResponseEntity<OneToManyBar> getOneToManyBarById (Long id);

}