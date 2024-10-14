package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseOneToOneOwnerUnidirectional;

@Entity
@Table (name="oneToOneOwnerUnidirectional")
public class OneToOneOwnerUnidirectional extends BaseOneToOneOwnerUnidirectional<OneToOneOwnerUnidirectional>
{
}