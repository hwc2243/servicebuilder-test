package com.test.model;

import jakarta.persistence.Entity;

@Entity
public class SubFoo extends Foo {
	
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
