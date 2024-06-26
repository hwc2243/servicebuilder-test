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

import com.test.model.OneToOneOwnedUnidirectional;

@Entity
public class BaseOneToOneOwnerUnidirectional extends AbstractBaseEntity
{
  @Column
  protected long a;

  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name= "oneToOneOwnedUnidirection_id", nullable=true)
  protected BaseOneToOneOwnedUnidirectional oneToOneOwnedUnidirection;
  

  public long getA ()
  {
    return this.a;
  }
  
  public void setA (long a)
  {
    this.a = a;
  }

  public OneToOneOwnedUnidirectional getOneToOneOwnedUnidirection ()
  {
    return (OneToOneOwnedUnidirectional)this.oneToOneOwnedUnidirection;
  }
  
  public void setOneToOneOwnedUnidirection (OneToOneOwnedUnidirectional oneToOneOwnedUnidirection)
  {
    this.oneToOneOwnedUnidirection = oneToOneOwnedUnidirection;
  }

}