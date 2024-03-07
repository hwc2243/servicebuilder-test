package com.test.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.base.service.ServiceException;
import com.test.model.Bar;
import com.test.model.Foo;
import com.test.model.SubFoo;

@SpringBootTest
public class FooServiceImplTest {

	@Autowired
	protected BarService barService;
	
	@Autowired
	protected FooService fooService;
	
	protected long a = 12345;
	protected long aPrime = 23456;
	protected String b = "This is a test";
	protected String bPrime = "This is another test";
	protected long c = 54321;
	protected long cPrime = 65432;
	protected boolean d = true;
	protected boolean dPrime = false;

	// create
	@Test
	public void whenFooCreated_thenFooShouldBeFound () {
		Foo foo = newFoo();
		
		try
		{
			Foo newFoo = fooService.create(foo);
			assertThat(newFoo).isNotNull();
			assertThat(newFoo.getId()).isGreaterThan(0);
			assertThat(newFoo.getA()).isEqualTo(a);
			assertThat(newFoo.getB()).isEqualTo(b);
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	// delete
	@Test
	public void whenFooDelete_thenFooShouldNotBeFound () {
		Foo foo = newFoo();
		
		try
		{
			foo = fooService.create(foo);
			assertThat(foo).isNotNull();
			fooService.delete(foo.getId());
			Foo deletedFoo = fooService.get(foo.getId());
			assertThat(deletedFoo).isNull();
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	// finders
	@Test
	public void whenValidA_thenFooShouldBeFound ()
	{
		Foo foo = newFoo();
		try
		{
			foo = fooService.create(foo);
			List<Foo> results = fooService.findByA(a);
			assertThat(results).isNotEmpty();
			assertThat(results.size()).isGreaterThan(0);
			assertThat(results.iterator().next().getA()).isEqualTo(a);
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	@Test
	public void whenInvalidA_thenFooShouldNotBeFound ()
	{
		Foo foo = newFoo();
		try
		{
			foo = fooService.create(foo);
			List<Foo> results = fooService.findByA(-99L);
			assertThat(results).isEmpty();
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	@Test
	public void whenValidAAndB_thenFooShouldBeFound ()
	{
		Foo foo = newFoo();
		try
		{
			fooService.create(foo);
			List<Foo> results = fooService.findByAAndB(a, b);
			assertThat(results).isNotEmpty();
			assertThat(results.size()).isGreaterThan(0);
			assertThat(results.iterator().next().getA()).isEqualTo(a);
			assertThat(results.iterator().next().getB()).isEqualTo(b);
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	@Test
	public void whenValidAAndInvalidB_thenFooShouldNotBeFound ()
	{
		Foo foo = new Foo();
		try
		{
			fooService.create(foo);
			List<Foo> results = fooService.findByAAndB(a, "invalid");
			assertThat(results).isEmpty();
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	@Test
	public void whenInvalidAandValidB_thenFooShouldNotBeFound ()
	{
		try
		{
			fooService.create(newFoo());
			List<Foo> results = fooService.findByAAndB(-99L, b);
			assertThat(results).isEmpty();
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	@Test
	public void whenInvalidAAndB_thenFooShouldNotBeFound ()
	{
		try
		{
			fooService.create(newFoo());
			List<Foo> results = fooService.findByAAndB(-99L, "invalid");
			assertThat(results).isEmpty();
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	// get
	@Test
	public void whenValidId_thenFooShouldBeFound () {
		try
		{
			Foo newFoo = fooService.create(newFoo());
			Foo fromDb = fooService.get(newFoo.getId());
			assertThat(fromDb).isNotNull();
			assertThat(fromDb.getId()).isEqualTo(newFoo.getId());
			assertThat(fromDb.getA()).isEqualTo(a);
			assertThat(fromDb.getB()).isEqualTo(b);
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	@Test
    public void whenInvalidId_thenFooShouldNotBeFound() {
		try
		{
			Foo fromDb = fooService.get(-99L);
	        //verifyFindByIdIsCalledOnce();
	        assertThat(fromDb).isNull();
		}
		catch (ServiceException ex)
		{
			
		}
    }
	
	// update
	@Test
	public void whenUpdate_thenFooShouldBeUpdated () {
		try
		{
			Foo newFoo = fooService.create(newFoo());
			newFoo.setA(aPrime);
			newFoo.setB(bPrime);
			Foo updatedFoo = fooService.update(newFoo);
			assertThat(newFoo.getId()).isEqualTo(updatedFoo.getId());
			assertThat(updatedFoo.getA()).isEqualTo(aPrime);
			assertThat(updatedFoo.getB()).isEqualTo(bPrime);
			
			Foo fromDb = fooService.get(newFoo.getId());
			assertThat(fromDb.getId()).isEqualTo(newFoo.getId());
			assertThat(fromDb.getA()).isEqualTo(aPrime);
			assertThat(fromDb.getB()).isEqualTo(bPrime);
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	// Bar
	@Test
	public void whenCreatedWithBar_thenBarShouldExist () {
		try
		{
			Bar newBar = barService.create(newBar());
			Foo newFoo = newFoo();
			newFoo.setBar(newBar);
			
			Foo createdFoo = fooService.create(newFoo);
			assertThat(createdFoo.getBar()).isNotNull();
			assertThat(createdFoo.getBar().getId()).isEqualTo(newBar.getId());
			assertThat(createdFoo.getBar().getC()).isEqualTo(c);
			assertThat(createdFoo.getBar().getD()).isEqualTo(d);
		}
		catch (ServiceException ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void whenBarUpdated_thenFooShouldUpdate () {
		try
		{
			Bar newBar = barService.create(newBar());
			Foo newFoo = newFoo();
			newFoo.setBar(newBar);
			
			Foo createdFoo = fooService.create(newFoo);
			
			newBar.setC(cPrime);
			newBar.setD(dPrime);
			barService.update(newBar);
			
			Foo fromDb = fooService.get(createdFoo.getId());
			
			assertThat(fromDb.getBar().getC()).isEqualTo(cPrime);
			assertThat(fromDb.getBar().getD()).isEqualTo(dPrime);
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	// Foo subclass
	@Test
	public void whenFooSubclassed_thenSubClassShouldSave ()
	{
		SubFoo subFoo = new SubFoo();
		subFoo.setA(a);
		subFoo.setB(b);
		subFoo.setE("subclassed foo");
		
		try
		{
			Foo createdFoo = fooService.create(subFoo);
			assertThat(createdFoo.getClass()).isEqualTo(SubFoo.class);
		}
		catch (ServiceException ex)
		{
			
		}
		
	}
	
	protected Foo newFoo ()
	{
		return newFoo(a, b);
	}
	
	protected Foo newFoo (long a, String b)
	{
		Foo foo = new Foo();
		foo.setA(a);
		foo.setB(b);
		return foo;
	}
	
	protected Bar newBar ()
	{
		return newBar(c, d);
	}
	
	protected Bar newBar (long c, boolean d)
	{
		Bar bar = new Bar();

		bar.setC(c);
		bar.setD(d);
		
		return bar;
	}
}
