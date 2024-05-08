package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseManyToManyBar;

public interface BaseManyToManyBarPersistence<T extends BaseManyToManyBar, ID> extends JpaRepository<T, ID>
{
} 