package com.test.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.db.DBSetup;
import com.test.model.ManyToOneBar;
import com.test.model.ManyToOneFoo;
import com.test.model.ManyToOneSubBar;
import com.test.model.ManyToOneSubFoo;

@SpringBootTest
public class ManyToOneServiceImplTest extends DBSetup {

	@Autowired
	protected ManyToOneBarService barService;
	
	@Autowired
	protected ManyToOneFooService fooService;
	
	protected long a = 12345;
	protected long aPrime = 23456;
	protected String b = "This is a test";
	protected String bPrime = "This is another test";
	protected long c = 54321;
	protected long cPrime = 65432;
	protected boolean d = true;
	protected boolean dPrime = false;
	protected String e = "subclassed foo";
	protected String ePrime = "another subclassed foo";
	protected double f = 135.7;
	protected double fPrime = 7.531;

	// create
	
	
	// Bar
	@Test
	public void whenCreatedWithBar_thenBarShouldExist () {
		try
		{
			ManyToOneBar newBar = barService.create(newBar());
			ManyToOneFoo newFoo = newFoo();
			newFoo.setManyToOneBar(newBar);
			
			ManyToOneFoo createdFoo = fooService.create(newFoo);
			assertThat(createdFoo.getManyToOneBar()).isNotNull();
			assertThat(createdFoo.getManyToOneBar().getId()).isEqualTo(newBar.getId());
			assertThat(createdFoo.getManyToOneBar().getC()).isEqualTo(c);
			assertThat(createdFoo.getManyToOneBar().getD()).isEqualTo(d);
		}
		catch (ServiceException ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void whenBarUpdated_thenFooShouldReflectUpdate () {
		try
		{
			ManyToOneBar newBar = barService.create(newBar());
			ManyToOneFoo newFoo = newFoo();
			newFoo.setManyToOneBar(newBar);
			
			ManyToOneFoo createdFoo = fooService.create(newFoo);
			
			newBar.setC(cPrime);
			newBar.setD(dPrime);
			barService.update(newBar);
			
			ManyToOneFoo fromDb = fooService.get(createdFoo.getId());
			
			assertThat(fromDb.getManyToOneBar().getC()).isEqualTo(cPrime);
			assertThat(fromDb.getManyToOneBar().getD()).isEqualTo(dPrime);
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	// Foo subclass
	@Test
	public void whenFooSubclassed_thenSubClassShouldSave ()
	{
		ManyToOneSubFoo subFoo = newSubFoo(a, b, e);
		
		try
		{
			ManyToOneFoo createdFoo = fooService.create(subFoo);
			assertThat(createdFoo.getClass()).isEqualTo(ManyToOneSubFoo.class);
			
			ManyToOneSubFoo createdSubFoo = (ManyToOneSubFoo)createdFoo;
			assertThat(createdSubFoo.getE()).isEqualTo(e);
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	// Bar subclass
	@Test
	public void whenBarSubclassed_thenSubClassShouldSave ()
	{
		ManyToOneSubBar subBar = newSubBar(c, d, f);
		
		try
		{
			ManyToOneBar createdBar = barService.create(subBar);
			ManyToOneFoo foo = newFoo();
			foo.setManyToOneBar(createdBar);
			
			ManyToOneFoo createdFoo = fooService.create(foo);
			ManyToOneBar fromFoo = createdFoo.getManyToOneBar();
			assertThat(fromFoo.getClass()).isEqualTo(ManyToOneSubBar.class);
			
		}
		catch (ServiceException ex)
		{
			ex.printStackTrace();
		}
	}
	
	protected ManyToOneFoo newFoo ()
	{
		return newFoo(a, b);
	}
	
	protected ManyToOneFoo newFoo (long a, String b)
	{
		ManyToOneFoo foo = new ManyToOneFoo();
		foo.setA(a);
		foo.setB(b);
		return foo;
	}
	
	protected ManyToOneSubFoo newSubFoo (long a, String b, String e)
	{
		ManyToOneSubFoo foo = new ManyToOneSubFoo();
		foo.setA(a);
		foo.setB(b);
		foo.setE(e);
		
		return foo;
	}
	
	protected ManyToOneBar newBar ()
	{
		return newBar(c, d);
	}
	
	protected ManyToOneBar newBar (long c, boolean d)
	{
		ManyToOneBar bar = new ManyToOneBar();

		bar.setC(c);
		bar.setD(d);
		
		return bar;
	}
	
	protected ManyToOneSubBar newSubBar (long c, boolean d, double f)
	{
		ManyToOneSubBar bar = new ManyToOneSubBar();
		bar.setC(c);
		bar.setD(d);
		bar.setF(f);
		
		return bar;
	}
}
