package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseManyToOneBar;

@Entity
@Table (name="manyToOneBar")
public class ManyToOneBar extends BaseManyToOneBar<ManyToOneBar>
{
}