package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseBasicBar;

@Entity
@Table (name="basicBar")
public class BasicBar extends BaseBasicBar<BasicBar>
{
}