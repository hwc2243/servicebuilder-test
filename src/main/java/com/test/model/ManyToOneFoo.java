package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseManyToOneFoo;

@Entity
@Table (name="manyToOneFoo")
public class ManyToOneFoo extends BaseManyToOneFoo<ManyToOneFoo>
{
}