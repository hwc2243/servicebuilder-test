package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseManyToOneBar;

public interface BaseManyToOneBarPersistence<T extends BaseManyToOneBar, ID> extends JpaRepository<T, ID>
{
} 