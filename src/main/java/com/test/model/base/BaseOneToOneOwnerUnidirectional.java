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

import com.test.model.OneToOneOwnerUnidirectional;
import com.test.model.OneToOneOwnedUnidirectional;

@MappedSuperclass
public abstract class BaseOneToOneOwnerUnidirectional<T extends BaseOneToOneOwnerUnidirectional> extends AbstractBaseEntity
    implements Serializable
{
  @Column
  protected long a;
  

  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name= "oneToOneOwnedUnidirectional_id", nullable=true)
  protected OneToOneOwnedUnidirectional oneToOneOwnedUnidirectional;
  

  public long getA ()
  {
    return this.a;
  }
  
  public void setA (long a)
  {
    this.a = a;
  }

  public OneToOneOwnedUnidirectional getOneToOneOwnedUnidirectional ()
  {
    return (OneToOneOwnedUnidirectional)this.oneToOneOwnedUnidirectional;
  }
  
  public void setOneToOneOwnedUnidirectional (OneToOneOwnedUnidirectional oneToOneOwnedUnidirectional)
  {
    this.oneToOneOwnedUnidirectional = oneToOneOwnedUnidirectional;
  }


}