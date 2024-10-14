package com.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.db.DBSetup;
import com.test.model.Foo;

@SpringBootTest
public class FooServiceImplTest extends DBSetup {
	protected static Logger logger = LoggerFactory.getLogger(FooServiceImplTest.class);
	
	public static final long A = 12345;
	public static final long A_PRIME = 23456;
	public static final String B = "This is a test";
	public static final String B_PRIME = "This is another test";
	
	@Autowired
	protected FooService fooService;
	
	@BeforeAll
	public static void beforeAll ()
	{
		logger.error("beforeAll()");
	}
	
	@Test
	public void whenFooCreated_thenFooShouldBeFound () {
		Foo foo = newFoo();
		
		try
		{
			Foo newFoo = fooService.create(foo);
			assertThat(newFoo).isNotNull();
			assertThat(newFoo.getId()).isGreaterThan(0);
			assertThat(newFoo.getA()).isEqualTo(A);
			assertThat(newFoo.getB()).isEqualTo(B);
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
			List<Foo> results = fooService.findByA(A);
			assertThat(results).isNotEmpty();
			assertThat(results.size()).isGreaterThan(0);
			assertThat(results.iterator().next().getA()).isEqualTo(A);
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
			List<Foo> results = fooService.findByAAndB(A, B);
			assertThat(results).isNotEmpty();
			assertThat(results.size()).isGreaterThan(0);
			assertThat(results.iterator().next().getA()).isEqualTo(A);
			assertThat(results.iterator().next().getB()).isEqualTo(B);
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
			List<Foo> results = fooService.findByAAndB(A, "invalid");
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
			List<Foo> results = fooService.findByAAndB(-99L, B);
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
			assertThat(fromDb.getA()).isEqualTo(A);
			assertThat(fromDb.getB()).isEqualTo(B);
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
			newFoo.setA(A_PRIME);
			newFoo.setB(B_PRIME);
			Foo updatedFoo = fooService.update(newFoo);
			assertThat(newFoo.getId()).isEqualTo(updatedFoo.getId());
			assertThat(updatedFoo.getA()).isEqualTo(A_PRIME);
			assertThat(updatedFoo.getB()).isEqualTo(B_PRIME);
			
			Foo fromDb = fooService.get(newFoo.getId());
			assertThat(fromDb.getId()).isEqualTo(newFoo.getId());
			assertThat(fromDb.getA()).isEqualTo(A_PRIME);
			assertThat(fromDb.getB()).isEqualTo(B_PRIME);
		}
		catch (ServiceException ex)
		{
			
		}
	}
	
	protected Foo newFoo ()
	{
		return newFoo(A, B);
	}
	
	protected Foo newFoo (long a, String b)
	{
		Foo foo = new Foo();
		foo.setA(a);
		foo.setB(b);
		return foo;
	}
}
