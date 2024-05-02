package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseOneToOneOwnerUnidirectional;

public interface BaseOneToOneOwnerUnidirectionalPersistence<T extends BaseOneToOneOwnerUnidirectional, ID> extends JpaRepository<T, ID>
{
} 