package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseOneToOneOwnerUnidirectional;
import com.test.model.OneToOneOwnerUnidirectional;

public interface BaseOneToOneOwnerUnidirectionalPersistence<T extends OneToOneOwnerUnidirectional, ID> extends JpaRepository<T, ID>
{
} 