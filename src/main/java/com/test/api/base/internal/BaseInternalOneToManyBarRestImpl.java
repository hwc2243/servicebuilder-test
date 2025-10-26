package com.test.api.base.internal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.model.OneToManyBar;

import com.test.service.OneToManyBarService;
import com.test.service.ServiceException;

import com.test.api.base.internal.BaseInternalOneToManyBarRest;

public abstract class BaseInternalOneToManyBarRestImpl implements BaseInternalOneToManyBarRest
{
	@Autowired
	protected OneToManyBarService oneToManyBarService;
	
	public ResponseEntity<OneToManyBar> getOneToManyBarById (@PathVariable Long id)
	{
		OneToManyBar entity = null;
		
		try	{
			entity = oneToManyBarService.get(id);
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