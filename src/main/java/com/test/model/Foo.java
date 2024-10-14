package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseFoo;

@Entity
@Table (name="foo")
public class Foo extends BaseFoo<Foo>
{
}