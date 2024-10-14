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

import com.test.model.OneToOneBidirectionalFoo;
import com.test.model.OneToOneBidirectionalBar;


/*
@Entity
@Table (name="oneToOneBidirectionalFoo")
*/
@MappedSuperclass
public abstract class BaseOneToOneBidirectionalFoo<T extends BaseOneToOneBidirectionalFoo> extends AbstractBaseEntity
    implements Serializable
{
  @Column
  protected long a;
  

  @OneToOne(mappedBy = "oneToOneBidirectionalFoo", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
  protected OneToOneBidirectionalBar oneToOneBidirectionalBar;
  

  public long getA ()
  {
    return this.a;
  }
  
  public void setA (long a)
  {
    this.a = a;
  }
  public OneToOneBidirectionalBar getOneToOneBidirectionalBar ()
  {
    return (OneToOneBidirectionalBar)this.oneToOneBidirectionalBar;
  }
  
  public void setOneToOneBidirectionalBar (OneToOneBidirectionalBar oneToOneBidirectionalBar)
  {
    this.oneToOneBidirectionalBar = oneToOneBidirectionalBar;
  }

}