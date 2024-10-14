package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseOneToOneBidirectionalFoo;

@Entity
@Table (name="oneToOneBidirectionalFoo")
public class OneToOneBidirectionalFoo extends BaseOneToOneBidirectionalFoo<OneToOneBidirectionalFoo>
{
}