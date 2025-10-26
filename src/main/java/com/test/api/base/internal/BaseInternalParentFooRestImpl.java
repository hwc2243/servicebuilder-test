package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.ParentFoo;

import com.test.service.ParentFooService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalParentFooRest;

public abstract class BaseInternalParentFooRestImpl implements BaseInternalParentFooRest
{
	@Autowired
	protected ParentFooService parentFooService;
	
	public ResponseEntity<ParentFoo> getParentFooById (@PathVariable Long id)
	{
		ParentFoo entity = null;
		
		try	{
			entity = parentFooService.get(id);
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