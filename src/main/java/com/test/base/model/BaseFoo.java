package com.test.base.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class BaseFoo extends AbstractBaseEntity
{
  @Column
  protected long a;

  @Column
  protected String b;


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
  
}