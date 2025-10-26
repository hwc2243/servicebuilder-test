package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.ManyToOneBar;

import com.test.service.ManyToOneBarService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalManyToOneBarRest;

public abstract class BaseInternalManyToOneBarRestImpl implements BaseInternalManyToOneBarRest
{
	@Autowired
	protected ManyToOneBarService manyToOneBarService;
	
	public ResponseEntity<ManyToOneBar> getManyToOneBarById (@PathVariable Long id)
	{
		ManyToOneBar entity = null;
		
		try	{
			entity = manyToOneBarService.get(id);
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