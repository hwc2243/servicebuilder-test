package com.test.model;

import jakarta.persistence.Entity;

@Entity
public class ManyToOneSubFoo extends ManyToOneFoo {
	
	protected String e;
	
	public String getE ()
	{
		return this.e;
	}
	
	public void setE (String e)
	{
		this.e = e;
	}
}