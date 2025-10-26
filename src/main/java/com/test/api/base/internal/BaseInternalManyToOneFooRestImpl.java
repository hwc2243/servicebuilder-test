package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.ManyToOneFoo;

import com.test.service.ManyToOneFooService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalManyToOneFooRest;

public abstract class BaseInternalManyToOneFooRestImpl implements BaseInternalManyToOneFooRest
{
	@Autowired
	protected ManyToOneFooService manyToOneFooService;
	
	public ResponseEntity<ManyToOneFoo> getManyToOneFooById (@PathVariable Long id)
	{
		ManyToOneFoo entity = null;
		
		try	{
			entity = manyToOneFooService.get(id);
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