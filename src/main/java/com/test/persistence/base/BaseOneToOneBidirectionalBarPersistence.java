package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseOneToOneBidirectionalBar;
import com.test.model.OneToOneBidirectionalBar;

public interface BaseOneToOneBidirectionalBarPersistence<T extends OneToOneBidirectionalBar, ID> extends JpaRepository<T, ID>
{
} 