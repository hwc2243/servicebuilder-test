package com.test.service;

import org.springframework.stereotype.Service;

import com.test.service.base.BaseOneToManyFooServiceImpl;

import com.test.model.OneToManyFoo;

@Service
public class OneToManyFooServiceImpl
  extends BaseOneToManyFooServiceImpl<OneToManyFoo,Long>
  implements OneToManyFooService
{
}