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

import com.test.model.OneToOneBidirectionalFoo;

@Entity
public class BaseOneToOneBidirectionalBar extends AbstractBaseEntity
{
  @Column
  protected String b;

  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name= "oneToOneBidirectionalFoo_id", nullable=true)
  protected BaseOneToOneBidirectionalFoo oneToOneBidirectionalFoo;
  

  public String getB ()
  {
    return this.b;
  }
  
  public void setB (String b)
  {
    this.b = b;
  }

  public OneToOneBidirectionalFoo getOneToOneBidirectionalFoo ()
  {
    return (OneToOneBidirectionalFoo)this.oneToOneBidirectionalFoo;
  }
  
  public void setOneToOneBidirectionalFoo (OneToOneBidirectionalFoo oneToOneBidirectionalFoo)
  {
    this.oneToOneBidirectionalFoo = oneToOneBidirectionalFoo;
  }

}