package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.OneToOneBidirectionalBar;

import com.test.service.OneToOneBidirectionalBarService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalOneToOneBidirectionalBarRest;

public abstract class BaseInternalOneToOneBidirectionalBarRestImpl implements BaseInternalOneToOneBidirectionalBarRest
{
	@Autowired
	protected OneToOneBidirectionalBarService oneToOneBidirectionalBarService;
	
	public ResponseEntity<OneToOneBidirectionalBar> getOneToOneBidirectionalBarById (@PathVariable Long id)
	{
		OneToOneBidirectionalBar entity = null;
		
		try	{
			entity = oneToOneBidirectionalBarService.get(id);
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