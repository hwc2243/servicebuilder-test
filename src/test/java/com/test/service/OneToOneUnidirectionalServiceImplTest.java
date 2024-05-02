package com.test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.model.OneToOneOwnedUnidirectional;
import com.test.model.OneToOneOwnerUnidirectional;

@SpringBootTest
public class OneToOneUnidirectionalServiceImplTest {

	protected long a = 789;
	protected String b = "Some test data";
	
	@Autowired
	protected OneToOneOwnerUnidirectionalService bazService;
	
	@Test
	public void whenBazQuzCreated_thenBazQuzFound ()
	{
		OneToOneOwnerUnidirectional oneToOneOwnerUnidirectional = oneToOneOwnerUnidirectional();
		oneToOneOwnerUnidirectional.setOneToOneOwnedUnidirection(oneToOneOwnedUnidirectional());
	}
	
	protected OneToOneOwnerUnidirectional oneToOneOwnerUnidirectional ()
	{
		OneToOneOwnerUnidirectional oneToOneOwnerUnidirectional = new OneToOneOwnerUnidirectional();
		
		oneToOneOwnerUnidirectional.setA(a);

		return oneToOneOwnerUnidirectional;
		
	}
	
	protected OneToOneOwnedUnidirectional oneToOneOwnedUnidirectional ()
	{
		OneToOneOwnedUnidirectional oneToOneOwnedUnidirectional = new OneToOneOwnedUnidirectional();
		oneToOneOwnedUnidirectional.setB(b);
		return oneToOneOwnedUnidirectional;
	}
}
