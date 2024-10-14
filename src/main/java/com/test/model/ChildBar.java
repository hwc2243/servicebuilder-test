package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseChildBar;

@Entity
@Table (name="childBar")
public class ChildBar extends BaseChildBar<ChildBar>
{
}