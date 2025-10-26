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

import com.test.model.ChildBar;
import com.test.model.ParentFoo;

@MappedSuperclass
public abstract class BaseChildBar<T extends BaseChildBar> extends ParentFoo<T>
    implements Serializable
{
  @Column
  protected String b;
  


  public String getB ()
  {
    return this.b;
  }
  
  public void setB (String b)
  {
    this.b = b;
  }

}