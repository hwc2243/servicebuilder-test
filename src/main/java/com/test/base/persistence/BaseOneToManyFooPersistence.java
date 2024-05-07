package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseOneToManyFoo;

public interface BaseOneToManyFooPersistence<T extends BaseOneToManyFoo, ID> extends JpaRepository<T, ID>
{
} 