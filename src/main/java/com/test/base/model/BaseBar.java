package com.test.base.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

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