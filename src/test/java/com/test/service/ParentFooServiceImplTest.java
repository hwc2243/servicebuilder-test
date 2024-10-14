package com.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.db.DBSetup;
import com.test.model.ChildBar;
import com.test.model.ChildBaz;
import com.test.model.ParentFoo;

@SpringBootTest
public class ParentFooServiceImplTest extends DBSetup {
	public static final int A1 = 1;
	public static final int A2 = 2;
	public static final String B = "child bar";
	public static final boolean C = true;
	
	@Autowired
	protected ParentFooService parentFooService;
	
	@Autowired
	protected ChildBarService childBarService;

	@Autowired
	protected ChildBazService childBazService;
	
	@Test
	public void whenInherited ()
	{
		ChildBar childBar = new ChildBar();
		childBar.setA(A1);
		childBar.setB(B);
		ChildBaz childBaz = new ChildBaz();
		childBaz.setA(A2);
		childBaz.setC(C);

		assertDoesNotThrow(() -> {
			ChildBar createdChildBar = childBarService.create(childBar);
			List<ParentFoo> foundFoos = parentFooService.findAll();
			assertThat(foundFoos).isNotNull();
			assertThat(foundFoos).hasSize(1);
			assertThat(foundFoos).first().isEqualTo(createdChildBar);
			List<ChildBar> foundBars = childBarService.findAll();
			assertThat(foundBars).isNotNull();
			assertThat(foundBars).hasSize(1);
			assertThat(foundBars).first().isEqualTo(createdChildBar);
			
			ChildBaz createdChildBaz = childBazService.create(childBaz);
			assertThat(createdChildBaz).isNotEqualTo(createdChildBar);
			foundFoos = parentFooService.findAll();
			assertThat(foundFoos).isNotNull();
			assertThat(foundFoos).hasSize(2);
			assertThat(foundFoos).contains(createdChildBar);
			assertThat(foundFoos).contains(createdChildBaz);
			
			List<ChildBar> foundChildBars = childBarService.findAll();
			assertThat(foundChildBars).isNotNull();
			assertThat(foundChildBars).hasSize(1);
			assertThat(foundChildBars).first().isEqualTo(createdChildBar);
			ChildBar foundChildBar = foundChildBars.get(0);
			assertThat(foundChildBar.getA()).isEqualTo(A1);
			assertThat(foundChildBar.getB()).isEqualTo(B);
			
			List<ChildBaz> foundChildBazs = childBazService.findAll();
			assertThat(foundChildBazs).isNotNull();
			assertThat(foundChildBazs).hasSize(1);
			assertThat(foundChildBazs).first().isEqualTo(createdChildBaz);
			ChildBaz foundChildBaz = foundChildBazs.get(0);
			assertThat(foundChildBaz.getA()).isEqualTo(A2);
			assertThat(foundChildBaz.getC()).isEqualTo(C);
						
		});
	}
}
