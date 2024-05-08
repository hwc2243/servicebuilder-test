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

import com.test.model.ManyToManyFoo;

@Entity
public class BaseManyToManyBar extends AbstractBaseEntity
{
  @Column
  protected String b;

  @ManyToMany(mappedBy = "manyToManyBars")
  protected List<BaseManyToManyFoo> manyToManyFoos;

  public String getB ()
  {
    return this.b;
  }
  
  public void setB (String b)
  {
    this.b = b;
  }

  public List<BaseManyToManyFoo> getManyToManyFoos ()
  {
    return this.manyToManyFoos;
  }
  
  public void setManyToManyFoos (List<BaseManyToManyFoo> manyToManyFoos)
  {
    this.manyToManyFoos = manyToManyFoos;
  }

}