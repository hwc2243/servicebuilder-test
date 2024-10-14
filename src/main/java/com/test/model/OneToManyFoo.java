package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseOneToManyFoo;

@Entity
@Table (name="oneToManyFoo")
public class OneToManyFoo extends BaseOneToManyFoo<OneToManyFoo>
{
}