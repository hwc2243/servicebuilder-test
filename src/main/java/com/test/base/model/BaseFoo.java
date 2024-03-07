package com.test.base.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.test.model.Bar;
@Entity
public class BaseFoo extends AbstractBaseEntity
{
  @Column
  protected long a;

  @Column
  protected String b;

  @OneToOne
  @JoinColumn(name= "bar_id", nullable=true)
  protected BaseBar bar;
  

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

  public Bar getBar ()
  {
    return (Bar)this.bar;
  }
  
  public void setBar (Bar bar)
  {
    this.bar = bar;
  }

}