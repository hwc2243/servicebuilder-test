package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseParentFoo;
import com.test.model.ParentFoo;

public interface BaseParentFooPersistence<T extends ParentFoo, ID> extends JpaRepository<T, ID>
{
} 