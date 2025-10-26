package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.ChildBaz;

import com.test.api.base.internal.BaseInternalChildBazRest;

public interface BaseInternalChildBazRest
{
	public ResponseEntity<ChildBaz> getChildBazById (Long id);

}