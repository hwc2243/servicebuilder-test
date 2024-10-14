package com.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.db.DBSetup;
import com.test.model.OneToOneOwnedUnidirectional;
import com.test.model.OneToOneOwnerUnidirectional;


@SpringBootTest
public class OneToOneUnidirectionalServiceImplTest extends DBSetup {

	protected long a = 789;
	protected String b = "Some test data";
	
	@Autowired
	protected OneToOneOwnerUnidirectionalService oneToOneOwnerService;

	@Autowired
	protected OneToOneOwnedUnidirectionalService oneToOneOwnedService;
	
	@Test
	public void whenOneToOneOwnerCreatedWithOwned_thenOneToOneOwnedFound ()
	{
		OneToOneOwnerUnidirectional oneToOneOwnerUnidirectional = oneToOneOwnerUnidirectional();
		oneToOneOwnerUnidirectional.setOneToOneOwnedUnidirectional(oneToOneOwnedUnidirectional());
		
		assertDoesNotThrow(() -> {
			OneToOneOwnerUnidirectional ownerCreated = oneToOneOwnerService.create(oneToOneOwnerUnidirectional);
			assertThat(ownerCreated).isNotNull();
			assertThat(ownerCreated.getId()).isGreaterThan(0);
			OneToOneOwnedUnidirectional ownedCreated = ownerCreated.getOneToOneOwnedUnidirectional();
			assertThat(ownedCreated).isNotNull();
			assertThat(ownedCreated.getId()).isGreaterThan(0);
			
			OneToOneOwnedUnidirectional ownedFound = oneToOneOwnedService.get(ownedCreated.getId());
			assertThat(ownedFound).isNotNull();
		});
	}
	
	@Test
	public void whenOneToOneOwnerDelete_thenOneToOneOwnedDeleted ()
	{
		OneToOneOwnerUnidirectional oneToOneOwnerUnidirectional = oneToOneOwnerUnidirectional();
		oneToOneOwnerUnidirectional.setOneToOneOwnedUnidirectional(oneToOneOwnedUnidirectional());

		assertDoesNotThrow(() -> {
			OneToOneOwnerUnidirectional created = oneToOneOwnerService.create(oneToOneOwnerUnidirectional);
			long createdOwnerId = created.getId();
			long createdOwnedId = created.getOneToOneOwnedUnidirectional().getId();
			oneToOneOwnerService.delete(createdOwnerId);
			
			OneToOneOwnerUnidirectional found = oneToOneOwnerService.get(createdOwnerId);
			assertThat(found).isNull();
			OneToOneOwnedUnidirectional foundOwned = oneToOneOwnedService.get(createdOwnedId);
			assertThat(foundOwned).isNull();
		});
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
