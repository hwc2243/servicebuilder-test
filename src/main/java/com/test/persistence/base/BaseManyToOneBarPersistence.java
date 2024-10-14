package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseManyToOneBar;
import com.test.model.ManyToOneBar;

public interface BaseManyToOneBarPersistence<T extends ManyToOneBar, ID> extends JpaRepository<T, ID>
{
} 