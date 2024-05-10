package com.test.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityTest {

	@Test
	public void whenTwoFoosWithSameId_thenEqualityOperationsShouldPass ()
	{
		BasicFoo foo1 = new BasicFoo();
		foo1.setId(1);
		BasicFoo foo2 = new BasicFoo();
		foo2.setId(1);
		
		assertThat(foo1).isEqualTo(foo2);
		assertThat(foo1.hashCode()).isEqualTo(foo2.hashCode());
	}
	
	@Test
	public void whenTwoFoosWithDifferentId_thenEqualityOperationsShouldFail ()
	{
		BasicFoo foo1 = new BasicFoo();
		foo1.setId(1);
		BasicFoo foo2 = new BasicFoo();
		foo2.setId(2);
		
		assertThat(foo1).isNotEqualTo(foo2);
		assertThat(foo1.hashCode()).isNotEqualTo(foo2.hashCode());
	}
	
	@Test
	public void whenFooAndBarWithSameId_thenEqualityOperationsShouldFail ()
	{
		BasicFoo foo = new BasicFoo();
		foo.setId(1);
		BasicBar bar = new BasicBar();
		bar.setId(1);
		
		assertThat(foo).isNotEqualTo(bar);
	}
	
	@Test
	public void whenFooSubclassed_thenEqualityOperationsShouldFail ()
	{
		BasicFoo basicFoo = new BasicFoo();
		basicFoo.setId(1);
		SubBasicFoo subFoo = new SubBasicFoo();
		subFoo.setId(1);
		
		assertThat(basicFoo).isNotEqualTo(subFoo);
		assertThat(basicFoo.hashCode()).isEqualTo(subFoo.hashCode());
	}
}
