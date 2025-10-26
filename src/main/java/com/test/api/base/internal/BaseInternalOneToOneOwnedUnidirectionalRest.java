package com.test.api.base.internal;

import org.springframework.http.ResponseEntity;

import com.test.model.OneToOneOwnedUnidirectional;

import com.test.api.base.internal.BaseInternalOneToOneOwnedUnidirectionalRest;

public interface BaseInternalOneToOneOwnedUnidirectionalRest
{
	public ResponseEntity<OneToOneOwnedUnidirectional> getOneToOneOwnedUnidirectionalById (Long id);

}