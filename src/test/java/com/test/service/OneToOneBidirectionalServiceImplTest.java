package com.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.db.DBSetup;
import com.test.model.OneToOneBidirectionalBar;
import com.test.model.OneToOneBidirectionalFoo;

@SpringBootTest
public class OneToOneBidirectionalServiceImplTest extends DBSetup {
	public static final long a = 12345;
	public static final String b = "this is b";

	@Autowired
	protected OneToOneBidirectionalFooService fooService;
	
	@Autowired
	protected OneToOneBidirectionalBarService barService;
	
	@Test
	public void whenOneToOneBidirectionalFooCreated_thenOneToOneBidirectionalBarCreated ()
	{
		assertDoesNotThrow(() -> {
			OneToOneBidirectionalFoo foo = newFoo();
			OneToOneBidirectionalBar bar = newBar();
			foo.setOneToOneBidirectionalBar(bar);
			bar.setOneToOneBidirectionalFoo(foo);

			// check that foo was created
			OneToOneBidirectionalFoo createdFoo = fooService.create(foo);
			assertThat(createdFoo).isNotNull();
			assertThat(createdFoo.getId()).isGreaterThan(0);
			
			// check that bar was created
			OneToOneBidirectionalBar createdBar = createdFoo.getOneToOneBidirectionalBar();
			assertThat(createdBar).isNotNull();
			assertThat(createdBar.getId()).isGreaterThan(0);
			
			// check that the created foo's and bar's attribute have the same value
			assertThat(foo.getA()).isEqualTo(createdFoo.getA());
			assertThat(bar.getB()).isEqualTo(createdBar.getB());
			
			// check that the created bar returns the created foo
			OneToOneBidirectionalFoo createdBarFoo = createdBar.getOneToOneBidirectionalFoo();
			assertThat(createdFoo.getId()).isEqualTo(createdBarFoo.getId());
		});
	}
	
	@Test
	public void whenOneToOneBidirectionFooCreated_thenOneToOneBidirectionalBarFound ()
	{
		assertDoesNotThrow(() -> {
			OneToOneBidirectionalFoo foo = newFoo();
			OneToOneBidirectionalBar bar = newBar();
			foo.setOneToOneBidirectionalBar(bar);
			bar.setOneToOneBidirectionalFoo(foo);

			OneToOneBidirectionalFoo createdFoo = fooService.create(foo);
			OneToOneBidirectionalBar createdBar = createdFoo.getOneToOneBidirectionalBar();
			
			// check that we can find bar
			OneToOneBidirectionalBar foundBar = barService.get(createdBar.getId());
			assertThat(foundBar).isNotNull();
			assertThat(foundBar.getId()).isEqualTo(createdBar.getId());
		});
	}
	
	@Test
	public void whenOneToOneBidirectionalFooCreated_thenOneToOneBidirectionalBarLinked ()
	{
		assertDoesNotThrow(() -> {
			OneToOneBidirectionalFoo foo = newFoo();
			OneToOneBidirectionalBar bar = newBar();
			foo.setOneToOneBidirectionalBar(bar);
			bar.setOneToOneBidirectionalFoo(foo);

			OneToOneBidirectionalFoo createdFoo = fooService.create(foo);
			OneToOneBidirectionalBar createdBar = createdFoo.getOneToOneBidirectionalBar();
			OneToOneBidirectionalBar foundBar = barService.get(createdBar.getId());
			
			// check that we can get foo from bar and that it is the same
			OneToOneBidirectionalFoo foundFoo = foundBar.getOneToOneBidirectionalFoo();
			assertThat(foundFoo).isNotNull();
			assertThat(foundFoo.getId()).isEqualTo(createdFoo.getId());
		});
	}
	
	@Test
	public void whenOneToOneBidirectionFooDeleted_thenOneToOneBidirectionalObjectsNotFound ()
	{
		assertDoesNotThrow(() -> {
			OneToOneBidirectionalFoo foo = newFoo();
			OneToOneBidirectionalBar bar = newBar();
			foo.setOneToOneBidirectionalBar(bar);
			bar.setOneToOneBidirectionalFoo(foo);

			OneToOneBidirectionalFoo createdFoo = fooService.create(foo);
			OneToOneBidirectionalBar createdBar = createdFoo.getOneToOneBidirectionalBar();
			fooService.delete(createdFoo.getId());
			
			// check if foo is found
			OneToOneBidirectionalFoo foundFoo = fooService.get(createdFoo.getId());
			assertThat(foundFoo).isNull();
					
			// check if bar is found
			OneToOneBidirectionalBar foundBar = barService.get(createdBar.getId());
			assertThat(foundBar).isNull();
		});
	}
	
	protected OneToOneBidirectionalFoo newFoo ()
	{
		OneToOneBidirectionalFoo foo = new OneToOneBidirectionalFoo();
		
		foo.setA(a);

		return foo;
	}
	
	protected OneToOneBidirectionalBar newBar ()
	{
		OneToOneBidirectionalBar bar = new OneToOneBidirectionalBar();
		bar.setB(b);
		return bar;
	}
}
