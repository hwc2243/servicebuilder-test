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

import com.test.model.ManyToOneBar;


/*
@Entity
@Table (name="manyToOneBar")
*/
@MappedSuperclass
public abstract class BaseManyToOneBar<T extends BaseManyToOneBar> extends AbstractBaseEntity
    implements Serializable
{
  @Column
  protected long c;
  
  @Column
  protected boolean d;
  


  public long getC ()
  {
    return this.c;
  }
  
  public void setC (long c)
  {
    this.c = c;
  }
  public boolean getD ()
  {
    return this.d;
  }
  
  public void setD (boolean d)
  {
    this.d = d;
  }
}