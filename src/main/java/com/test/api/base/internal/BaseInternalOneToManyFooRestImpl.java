package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.OneToManyFoo;

import com.test.service.OneToManyFooService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalOneToManyFooRest;

public abstract class BaseInternalOneToManyFooRestImpl implements BaseInternalOneToManyFooRest
{
	@Autowired
	protected OneToManyFooService oneToManyFooService;
	
	public ResponseEntity<OneToManyFoo> getOneToManyFooById (@PathVariable Long id)
	{
		OneToManyFoo entity = null;
		
		try	{
			entity = oneToManyFooService.get(id);
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