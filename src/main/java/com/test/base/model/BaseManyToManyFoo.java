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

import com.test.model.ManyToManyBar;

@Entity
public class BaseManyToManyFoo extends AbstractBaseEntity
{
  @Column
  protected long a;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "manyToManyFoo_manyToManyBar",
             joinColumns = @JoinColumn(name = "manyToManyFoo_id"),
             inverseJoinColumns = @JoinColumn(name = "manyToManyBar_id"))
  protected List<BaseManyToManyBar> manyToManyBars;

  public long getA ()
  {
    return this.a;
  }
  
  public void setA (long a)
  {
    this.a = a;
  }

  public List<BaseManyToManyBar> getManyToManyBars ()
  {
    return this.manyToManyBars;
  }
  
  public void setManyToManyBars (List<BaseManyToManyBar> manyToManyBars)
  {
    this.manyToManyBars = manyToManyBars;
  }

}