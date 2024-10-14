package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseOneToOneOwnedUnidirectional;
import com.test.model.OneToOneOwnedUnidirectional;

public interface BaseOneToOneOwnedUnidirectionalPersistence<T extends OneToOneOwnedUnidirectional, ID> extends JpaRepository<T, ID>
{
} 