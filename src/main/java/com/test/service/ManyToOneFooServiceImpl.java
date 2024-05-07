package com.test.service;

import org.springframework.stereotype.Service;

import com.test.base.service.BaseManyToOneFooServiceImpl;

import com.test.model.ManyToOneFoo;

@Service
public class ManyToOneFooServiceImpl
  extends BaseManyToOneFooServiceImpl<ManyToOneFoo,Long>
  implements ManyToOneFooService
{
}