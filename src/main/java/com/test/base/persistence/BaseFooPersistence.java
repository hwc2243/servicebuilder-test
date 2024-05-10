package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseFoo;

public interface BaseFooPersistence<T extends BaseFoo, ID> extends JpaRepository<T, ID>
{
} 