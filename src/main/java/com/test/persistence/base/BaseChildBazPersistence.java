package com.test.persistence.base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.base.BaseChildBaz;
import com.test.model.ChildBaz;

public interface BaseChildBazPersistence<T extends ChildBaz, ID> extends JpaRepository<T, ID>
{
} 