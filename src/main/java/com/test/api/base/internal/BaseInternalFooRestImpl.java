package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.Foo;

import com.test.service.FooService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalFooRest;

public abstract class BaseInternalFooRestImpl implements BaseInternalFooRest
{
	@Autowired
	protected FooService fooService;
	
	public ResponseEntity<Foo> getFooById (@PathVariable Long id)
	{
		Foo entity = null;
		
		try	{
			entity = fooService.get(id);
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