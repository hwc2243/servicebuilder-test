package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseOneToManyBar;
import com.test.model.OneToManyBar;

public interface BaseOneToManyBarPersistence<T extends OneToManyBar, ID> extends JpaRepository<T, ID>
{
} 