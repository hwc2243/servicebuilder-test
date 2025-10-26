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

import com.test.model.OneToManyFoo;
import com.test.model.OneToManyBar;

@MappedSuperclass
public abstract class BaseOneToManyFoo<T extends BaseOneToManyFoo> extends AbstractBaseEntity
    implements Serializable
{
  @Column
  protected long a;
  

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "oneToManyFooId")
  protected List<OneToManyBar> oneToManyBars;
  

  public long getA ()
  {
    return this.a;
  }
  
  public void setA (long a)
  {
    this.a = a;
  }

  public List<OneToManyBar> getOneToManyBars ()
  {
    return this.oneToManyBars;
  }
  
  public void setOneToManyBars (List<OneToManyBar> oneToManyBars)
  {
    this.oneToManyBars = oneToManyBars;
  }


}