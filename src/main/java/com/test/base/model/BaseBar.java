package com.test.base.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class BaseBar extends AbstractBaseEntity
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