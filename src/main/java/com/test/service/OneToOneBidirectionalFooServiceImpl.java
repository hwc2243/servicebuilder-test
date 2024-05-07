package com.test.service;

import org.springframework.stereotype.Service;

import com.test.base.service.BaseOneToOneBidirectionalFooServiceImpl;

import com.test.model.OneToOneBidirectionalFoo;

@Service
public class OneToOneBidirectionalFooServiceImpl
  extends BaseOneToOneBidirectionalFooServiceImpl<OneToOneBidirectionalFoo,Long>
  implements OneToOneBidirectionalFooService
{
}