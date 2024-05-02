package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseOneToOneOwnedUnidirectional;

public interface BaseOneToOneOwnedUnidirectionalPersistence<T extends BaseOneToOneOwnedUnidirectional, ID> extends JpaRepository<T, ID>
{
} 