package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import com.test.model.base.BaseOneToOneBidirectionalBar;

@Entity
@Table (name="oneToOneBidirectionalBar")
public class OneToOneBidirectionalBar extends BaseOneToOneBidirectionalBar<OneToOneBidirectionalBar>
{
}