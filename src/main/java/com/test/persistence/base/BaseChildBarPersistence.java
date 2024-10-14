package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseChildBar;
import com.test.model.ChildBar;

public interface BaseChildBarPersistence<T extends ChildBar, ID> extends JpaRepository<T, ID>
{
} 