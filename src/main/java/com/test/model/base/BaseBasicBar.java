package com.test.model.base;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

import com.test.model.BasicBar;


/*
@Entity
@Table (name="basicBar")
*/
@MappedSuperclass
public abstract class BaseBasicBar<T extends BaseBasicBar> extends AbstractBaseEntity
    implements Serializable
{
  @Column
  protected String bar;
  


  public String getBar ()
  {
    return this.bar;
  }
  
  public void setBar (String bar)
  {
    this.bar = bar;
  }
}