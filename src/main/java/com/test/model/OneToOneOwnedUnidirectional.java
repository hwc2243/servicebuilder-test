package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseOneToOneOwnedUnidirectional;

@Entity
@Table (name="oneToOneOwnedUnidirectional")
public class OneToOneOwnedUnidirectional extends BaseOneToOneOwnedUnidirectional<OneToOneOwnedUnidirectional>
{
}