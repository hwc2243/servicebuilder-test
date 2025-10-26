package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.OneToOneOwnedUnidirectional;

import com.test.service.OneToOneOwnedUnidirectionalService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalOneToOneOwnedUnidirectionalRest;

public abstract class BaseInternalOneToOneOwnedUnidirectionalRestImpl implements BaseInternalOneToOneOwnedUnidirectionalRest
{
	@Autowired
	protected OneToOneOwnedUnidirectionalService oneToOneOwnedUnidirectionalService;
	
	public ResponseEntity<OneToOneOwnedUnidirectional> getOneToOneOwnedUnidirectionalById (@PathVariable Long id)
	{
		OneToOneOwnedUnidirectional entity = null;
		
		try	{
			entity = oneToOneOwnedUnidirectionalService.get(id);
		}
		catch (ServiceException ex) {
			ex.printStackTrace();
		}
		
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}