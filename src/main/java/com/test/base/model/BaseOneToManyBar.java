package com.test.base.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

import com.test.model.OneToManyFoo;

@Entity
public class BaseOneToManyBar extends AbstractBaseEntity
{
  @Column
  protected String b;

  @ManyToOne
  @JoinColumn(name= "oneToManyFooId", nullable=true)
  protected BaseOneToManyFoo oneToManyFoo;


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