package com.test.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityTest {

	@Test
	public void whenTwoFoosWithSameId_thenEqualityOperationsShouldPass ()
	{
		Foo foo1 = new Foo();
		foo1.setId(1);
		Foo foo2 = new Foo();
		foo2.setId(1);
		
		assertThat(foo1).isEqualTo(foo2);
		assertThat(foo1.hashCode()).isEqualTo(foo2.hashCode());
	}
	
	@Test
	public void whenTwoFoosWithDifferentId_thenEqualityOperationsShouldFail ()
	{
		Foo foo1 = new Foo();
		foo1.setId(1);
		Foo foo2 = new Foo();
		foo2.setId(2);
		
		assertThat(foo1).isNotEqualTo(foo2);
		assertThat(foo1.hashCode()).isNotEqualTo(foo2.hashCode());
	}
	
	@Test
	public void whenFooAndBarWithSameId_thenEqualityOperationsShouldFail ()
	{
		Foo foo = new Foo();
		foo.setId(1);
		Bar bar = new Bar();
		bar.setId(1);
		
		assertThat(foo).isNotEqualTo(bar);
	}
}
