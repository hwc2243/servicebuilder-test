package com.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.db.DBSetup;

/*
import com.test.base.model.BaseManyToManyBar;
import com.test.base.model.BaseManyToManyFoo;
import com.test.model.ManyToManyBar;
import com.test.model.ManyToManyFoo;

*/
import jakarta.transaction.Transactional;

@SpringBootTest
public class ManyToManyServiceImplTest extends DBSetup {
	public static final long a = 3456;
	public static final String b = "ManyToMany bar string";

	/*
	@Autowired
	public ManyToManyFooService fooService;
	
	@Autowired
	public ManyToManyBarService barService;
	
	
	@Test
	@Transactional
	public void whenFooAndBarCreated_thenFooAndBarFoundAndLinked ()
	{
		ManyToManyFoo newFoo = newFoo();
		ManyToManyBar newBar = newBar();
		List<BaseManyToManyFoo> newFoos = new ArrayList<>();
		List<BaseManyToManyBar> newBars = new ArrayList<>();
		
		newFoos.add(newFoo);
		newBars.add(newBar);
		newFoo.setManyToManyBars(newBars);
		newBar.setManyToManyFoos(newFoos);
		
		assertDoesNotThrow(() -> {
			ManyToManyFoo createdFoo = fooService.create(newFoo);
			ManyToManyBar createdBar = barService.create(newBar);
			assertThat(createdFoo.getManyToManyBars()).isNotEmpty();
			assertThat(createdFoo.getManyToManyBars().size()).isEqualTo(1);
			assertThat(createdBar.getManyToManyFoos()).isNotEmpty();
			assertThat(createdBar.getManyToManyFoos().size()).isEqualTo(1);
		});
	}
	
	protected ManyToManyFoo newFoo ()
	{
		ManyToManyFoo foo = new ManyToManyFoo();
		foo.setA(a);
		return foo;
	}
	
	protected ManyToManyBar newBar ()
	{
		ManyToManyBar bar = new ManyToManyBar();
		bar.setB(b);
		return bar;
	}
	*/
}
