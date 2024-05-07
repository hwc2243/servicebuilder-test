package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseOneToOneBidirectionalFoo;

public interface BaseOneToOneBidirectionalFooPersistence<T extends BaseOneToOneBidirectionalFoo, ID> extends JpaRepository<T, ID>
{
} 