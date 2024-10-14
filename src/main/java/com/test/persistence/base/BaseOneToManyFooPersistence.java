package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseOneToManyFoo;
import com.test.model.OneToManyFoo;

public interface BaseOneToManyFooPersistence<T extends OneToManyFoo, ID> extends JpaRepository<T, ID>
{
} 