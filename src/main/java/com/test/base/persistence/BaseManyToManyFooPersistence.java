package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseManyToManyFoo;

public interface BaseManyToManyFooPersistence<T extends BaseManyToManyFoo, ID> extends JpaRepository<T, ID>
{
} 