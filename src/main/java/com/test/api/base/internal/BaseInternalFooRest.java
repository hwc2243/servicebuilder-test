package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.Foo;

import com.test.api.base.internal.BaseInternalFooRest;

public interface BaseInternalFooRest
{
	public ResponseEntity<Foo> getFooById (Long id);

}