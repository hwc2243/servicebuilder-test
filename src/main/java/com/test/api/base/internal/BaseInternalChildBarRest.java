package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.ChildBar;

import com.test.api.base.internal.BaseInternalChildBarRest;

public interface BaseInternalChildBarRest
{
	public ResponseEntity<ChildBar> getChildBarById (Long id);

}