package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseOneToManyBar;

public interface BaseOneToManyBarPersistence<T extends BaseOneToManyBar, ID> extends JpaRepository<T, ID>
{
} 