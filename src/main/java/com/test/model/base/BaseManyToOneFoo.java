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

import com.test.model.ManyToOneFoo;
import com.test.model.ManyToOneBar;

@MappedSuperclass
public abstract class BaseManyToOneFoo<T extends BaseManyToOneFoo> extends AbstractBaseEntity
    implements Serializable
{
  @Column
  protected long a;
  
  @Column
  protected String b;
  

  @ManyToOne
  @JoinColumn(name= "manyToOneBarId", nullable=true)
  protected ManyToOneBar manyToOneBar;


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