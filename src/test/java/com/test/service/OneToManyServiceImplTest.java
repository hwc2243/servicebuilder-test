package com.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.base.model.BaseOneToManyBar;
import com.test.model.OneToManyBar;
import com.test.model.OneToManyFoo;

@SpringBootTest
public class OneToManyServiceImplTest {
	public static final long a = 12345;
	public static final String b1 = "this is b1";
	public static final String b2 = "this is b2";

	@Autowired
	protected OneToManyFooService fooService;
	
	@Autowired
	protected OneToManyBarService barService;
	
	@Test
	public void whenOneToManyFooCreated_thenOneToManyBarsCreated ()
	{
		assertDoesNotThrow(() -> {
			OneToManyFoo newFoo = newFoo();
			OneToManyBar newBar1 = newBar1();
			newBar1.setOneToManyFoo(newFoo);
			OneToManyBar newBar2 = newBar2();
			newBar2.setOneToManyFoo(newFoo);
			List<BaseOneToManyBar> newBars = Arrays.asList(newBar1, newBar2);
			newFoo.setOneToManyBars(newBars);
			
			// test that foo is created and has the bar entities
			OneToManyFoo createdFoo = fooService.create(newFoo);
			assertThat(createdFoo).isNotNull();
			assertThat(createdFoo.getId()).isGreaterThan(0);
			List<BaseOneToManyBar> createdBars = createdFoo.getOneToManyBars();
			assertThat(createdBars).isNotNull();
			assertThat(createdBars.size()).isEqualTo(newBars.size());
		});
	}

	@Test
	public void whenOneToManyFooCreated_thenOneToManyBarsFound ()
	{
		assertDoesNotThrow(() -> {
			OneToManyFoo newFoo = newFooBars();
			
			OneToManyFoo createdFoo = fooService.create(newFoo);
			List<BaseOneToManyBar> createdBars = createdFoo.getOneToManyBars();
			createdBars.stream().forEach(createdBar -> {
				assertDoesNotThrow(() -> {
					OneToManyBar foundBar = barService.get(createdBar.getId());
					assertThat(foundBar).isNotNull();
					assertThat(createdBar.getId()).isEqualTo(foundBar.getId());
					assertThat(foundBar.getOneToManyFoo().getId()).isEqualTo(createdFoo.getId());
				});
			});
		});
	}
	
	@Test
	public void whenOneToManyFooCreated_thenOneToManyBarsLinked ()
	{
		assertDoesNotThrow(() -> {
			OneToManyFoo newFoo = newFooBars();
			
			OneToManyFoo createdFoo = fooService.create(newFoo);
			List<BaseOneToManyBar> createdBars = createdFoo.getOneToManyBars();
			createdBars.stream().forEach(createdBar -> {
				assertThat(createdBar.getId()).isNotNull();
				assertThat(createdBar.getOneToManyFoo()).isNotNull();
				assertThat(createdBar.getOneToManyFoo().getId()).isEqualTo(createdFoo.getId());
			});
		});
	}
	
	protected OneToManyFoo newFoo ()
	{
		OneToManyFoo foo = new OneToManyFoo();
		foo.setA(a);
		return foo;
	}
	
	protected OneToManyBar newBar1 ()
	{
		OneToManyBar bar = new OneToManyBar();
		bar.setB(b1);
		return bar;
	}

	protected OneToManyBar newBar2 ()
	{
		OneToManyBar bar = new OneToManyBar();
		bar.setB(b2);
		return bar;
	}
	
	protected OneToManyFoo newFooBars ()
	{
		OneToManyFoo newFoo = newFoo();
		OneToManyBar newBar1 = newBar1();
		newBar1.setOneToManyFoo(newFoo);
		OneToManyBar newBar2 = newBar2();
		newBar2.setOneToManyFoo(newFoo);
		List<BaseOneToManyBar> newBars = Arrays.asList(newBar1, newBar2);
		newFoo.setOneToManyBars(newBars);
		
		
		return newFoo;
	}
}
