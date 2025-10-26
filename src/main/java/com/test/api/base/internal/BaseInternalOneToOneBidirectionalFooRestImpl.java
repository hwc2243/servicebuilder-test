package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.OneToOneBidirectionalFoo;

import com.test.service.OneToOneBidirectionalFooService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalOneToOneBidirectionalFooRest;

public abstract class BaseInternalOneToOneBidirectionalFooRestImpl implements BaseInternalOneToOneBidirectionalFooRest
{
	@Autowired
	protected OneToOneBidirectionalFooService oneToOneBidirectionalFooService;
	
	public ResponseEntity<OneToOneBidirectionalFoo> getOneToOneBidirectionalFooById (@PathVariable Long id)
	{
		OneToOneBidirectionalFoo entity = null;
		
		try	{
			entity = oneToOneBidirectionalFooService.get(id);
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