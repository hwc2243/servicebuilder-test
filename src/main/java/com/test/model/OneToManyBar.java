package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseOneToManyBar;

@Entity
@Table (name="oneToManyBar")
public class OneToManyBar extends BaseOneToManyBar<OneToManyBar>
{
}