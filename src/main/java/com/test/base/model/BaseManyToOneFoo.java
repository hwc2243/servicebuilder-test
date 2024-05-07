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

import com.test.model.ManyToOneBar;

@Entity
public class BaseManyToOneFoo extends AbstractBaseEntity
{
  @Column
  protected long a;

  @Column
  protected String b;

  @ManyToOne
  @JoinColumn(name= "manyToOneBarId", nullable=true)
  protected BaseManyToOneBar manyToOneBar;


  public long getA ()
  {
    return this.a;
  }
  
  public void setA (long a)
  {
    this.a = a;
  }

  public String getB ()
  {
    return this.b;
  }
  
  public void setB (String b)
  {
    this.b = b;
  }

  public ManyToOneBar getManyToOneBar ()
  {
    return (ManyToOneBar)this.manyToOneBar;
  }
  
  public void setManyToOneBar (ManyToOneBar manyToOneBar)
  {
    this.manyToOneBar = manyToOneBar;
  }

}