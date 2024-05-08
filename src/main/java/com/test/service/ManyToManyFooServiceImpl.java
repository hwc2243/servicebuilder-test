package com.test.service;

import org.springframework.stereotype.Service;

import com.test.base.service.BaseManyToManyFooServiceImpl;

import com.test.model.ManyToManyFoo;

@Service
public class ManyToManyFooServiceImpl
  extends BaseManyToManyFooServiceImpl<ManyToManyFoo,Long>
  implements ManyToManyFooService
{
}