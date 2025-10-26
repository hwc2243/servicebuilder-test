package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.ParentFoo;

import com.test.api.base.internal.BaseInternalParentFooRest;

public interface BaseInternalParentFooRest
{
	public ResponseEntity<ParentFoo> getParentFooById (Long id);

}