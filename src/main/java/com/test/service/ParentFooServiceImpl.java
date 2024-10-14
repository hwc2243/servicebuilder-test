package com.test.service;

import org.springframework.stereotype.Service;

import com.test.service.base.BaseParentFooServiceImpl;

import com.test.model.ParentFoo;

@Service
public class ParentFooServiceImpl
  extends BaseParentFooServiceImpl<ParentFoo,Long>
  implements ParentFooService
{
}