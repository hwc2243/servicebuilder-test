package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseParentFoo;

@Entity
@Table (name="parentFoo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ParentFoo<T extends BaseParentFoo> extends BaseParentFoo<T>
{
}