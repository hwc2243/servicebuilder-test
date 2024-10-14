package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseChildBaz;

@Entity
@Table (name="childBaz")
public class ChildBaz extends BaseChildBaz<ChildBaz>
{
}