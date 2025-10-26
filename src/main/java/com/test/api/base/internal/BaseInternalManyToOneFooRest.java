package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.ManyToOneFoo;

import com.test.api.base.internal.BaseInternalManyToOneFooRest;

public interface BaseInternalManyToOneFooRest
{
	public ResponseEntity<ManyToOneFoo> getManyToOneFooById (Long id);

}