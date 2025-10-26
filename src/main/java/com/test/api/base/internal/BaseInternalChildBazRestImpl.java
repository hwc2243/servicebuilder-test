package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.ChildBaz;

import com.test.service.ChildBazService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalChildBazRest;

public abstract class BaseInternalChildBazRestImpl implements BaseInternalChildBazRest
{
	@Autowired
	protected ChildBazService childBazService;
	
	public ResponseEntity<ChildBaz> getChildBazById (@PathVariable Long id)
	{
		ChildBaz entity = null;
		
		try	{
			entity = childBazService.get(id);
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