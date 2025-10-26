package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.OneToManyFoo;

import com.test.api.base.internal.BaseInternalOneToManyFooRest;

public interface BaseInternalOneToManyFooRest
{
	public ResponseEntity<OneToManyFoo> getOneToManyFooById (Long id);

}