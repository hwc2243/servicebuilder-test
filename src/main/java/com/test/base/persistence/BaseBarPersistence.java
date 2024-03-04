package com.test.base.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.base.model.BaseBar;

public interface BaseBarPersistence<T extends BaseBar, ID> extends JpaRepository<T, ID>
{
} 