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

import com.test.model.OneToManyBar;
import com.test.model.OneToManyFoo;

@MappedSuperclass
public abstract class BaseOneToManyBar<T extends BaseOneToManyBar> extends AbstractBaseEntity
    implements Serializable
{
  @Column
  protected String b;
  

  @ManyToOne
  @JoinColumn(name= "oneToManyFooId", nullable=true)
  protected OneToManyFoo oneToManyFoo;


  public String getB ()
  {
    return this.b;
  }
  
  public void setB (String b)
  {
    this.b = b;
  }

  public OneToManyFoo getOneToManyFoo ()
  {
    return (OneToManyFoo)this.oneToManyFoo;
  }
  
  public void setOneToManyFoo (OneToManyFoo oneToManyFoo)
  {
    this.oneToManyFoo = oneToManyFoo;
  }


}