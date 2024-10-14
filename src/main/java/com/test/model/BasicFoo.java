package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseBasicFoo;

@Entity
@Table (name="basicFoo")
public class BasicFoo extends BaseBasicFoo<BasicFoo>
{
}