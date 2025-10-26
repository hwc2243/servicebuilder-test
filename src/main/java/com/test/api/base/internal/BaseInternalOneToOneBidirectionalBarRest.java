package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.OneToOneBidirectionalBar;

import com.test.api.base.internal.BaseInternalOneToOneBidirectionalBarRest;

public interface BaseInternalOneToOneBidirectionalBarRest
{
	public ResponseEntity<OneToOneBidirectionalBar> getOneToOneBidirectionalBarById (Long id);

}