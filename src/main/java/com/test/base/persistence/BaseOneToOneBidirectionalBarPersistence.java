package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseOneToOneBidirectionalBar;

public interface BaseOneToOneBidirectionalBarPersistence<T extends BaseOneToOneBidirectionalBar, ID> extends JpaRepository<T, ID>
{
} 