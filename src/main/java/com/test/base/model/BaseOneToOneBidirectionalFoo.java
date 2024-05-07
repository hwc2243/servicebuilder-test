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

import com.test.model.OneToOneBidirectionalBar;

@Entity
public class BaseOneToOneBidirectionalFoo extends AbstractBaseEntity
{
  @Column
  protected long a;

  @OneToOne(mappedBy = "oneToOneBidirectionalFoo", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
  protected BaseOneToOneBidirectionalBar oneToOneBidirectionalBar;
  

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