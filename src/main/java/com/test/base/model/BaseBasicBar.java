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


@Entity
public class BaseBasicBar extends AbstractBaseEntity
{
  @Column
  protected String bar;


  public String getBar ()
  {
    return this.bar;
  }
  
  public void setBar (String bar)
  {
    this.bar = bar;
  }

}