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

import com.test.model.OneToManyBar;

@Entity
public class BaseOneToManyFoo extends AbstractBaseEntity
{
  @Column
  protected long a;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "oneToManyFooId")
  protected List<BaseOneToManyBar> oneToManyBars;
  

  public long getA ()
  {
    return this.a;
  }
  
  public void setA (long a)
  {
    this.a = a;
  }

  public List<BaseOneToManyBar> getOneToManyBars ()
  {
    return this.oneToManyBars;
  }
  
  public void setOneToManyBars (List<BaseOneToManyBar> oneToManyBars)
  {
    this.oneToManyBars = oneToManyBars;
  }

}