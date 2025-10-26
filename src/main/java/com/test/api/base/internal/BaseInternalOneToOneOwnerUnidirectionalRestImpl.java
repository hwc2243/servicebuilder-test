package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.OneToOneOwnerUnidirectional;

import com.test.service.OneToOneOwnerUnidirectionalService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalOneToOneOwnerUnidirectionalRest;

public abstract class BaseInternalOneToOneOwnerUnidirectionalRestImpl implements BaseInternalOneToOneOwnerUnidirectionalRest
{
	@Autowired
	protected OneToOneOwnerUnidirectionalService oneToOneOwnerUnidirectionalService;
	
	public ResponseEntity<OneToOneOwnerUnidirectional> getOneToOneOwnerUnidirectionalById (@PathVariable Long id)
	{
		OneToOneOwnerUnidirectional entity = null;
		
		try	{
			entity = oneToOneOwnerUnidirectionalService.get(id);
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