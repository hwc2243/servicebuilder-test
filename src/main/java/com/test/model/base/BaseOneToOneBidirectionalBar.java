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

import com.test.model.OneToOneBidirectionalBar;
import com.test.model.OneToOneBidirectionalFoo;


/*
@Entity
@Table (name="oneToOneBidirectionalBar")
*/
@MappedSuperclass
public abstract class BaseOneToOneBidirectionalBar<T extends BaseOneToOneBidirectionalBar> extends AbstractBaseEntity
    implements Serializable
{
  @Column
  protected String b;
  

  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name= "oneToOneBidirectionalFoo_id", nullable=true)
  protected OneToOneBidirectionalFoo oneToOneBidirectionalFoo;
  

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