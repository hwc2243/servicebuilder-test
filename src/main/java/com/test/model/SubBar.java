package com.test.model;

import jakarta.persistence.Entity;

@Entity
public class SubBar extends Bar {
	protected double f;
	
	public double getF ()
	{
		return this.f;
	}
	
	public void setF (double f)
	{
		this.f = f;
	}
}
