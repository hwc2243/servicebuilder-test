package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.OneToOneBidirectionalFoo;

import com.test.api.base.internal.BaseInternalOneToOneBidirectionalFooRest;

public interface BaseInternalOneToOneBidirectionalFooRest
{
	public ResponseEntity<OneToOneBidirectionalFoo> getOneToOneBidirectionalFooById (Long id);

}