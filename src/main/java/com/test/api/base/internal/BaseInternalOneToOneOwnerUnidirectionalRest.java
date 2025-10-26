package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.OneToOneOwnerUnidirectional;

import com.test.api.base.internal.BaseInternalOneToOneOwnerUnidirectionalRest;

public interface BaseInternalOneToOneOwnerUnidirectionalRest
{
	public ResponseEntity<OneToOneOwnerUnidirectional> getOneToOneOwnerUnidirectionalById (Long id);

}