package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseOneToOneBidirectionalFoo;
import com.test.model.OneToOneBidirectionalFoo;

public interface BaseOneToOneBidirectionalFooPersistence<T extends OneToOneBidirectionalFoo, ID> extends JpaRepository<T, ID>
{
} 