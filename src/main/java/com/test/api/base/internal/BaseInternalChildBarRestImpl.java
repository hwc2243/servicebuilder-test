package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.ChildBar;

import com.test.service.ChildBarService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalChildBarRest;

public abstract class BaseInternalChildBarRestImpl implements BaseInternalChildBarRest
{
	@Autowired
	protected ChildBarService childBarService;
	
	public ResponseEntity<ChildBar> getChildBarById (@PathVariable Long id)
	{
		ChildBar entity = null;
		
		try	{
			entity = childBarService.get(id);
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