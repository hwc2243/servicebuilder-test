package com.test.service;

import org.springframework.stereotype.Service;

import com.test.base.service.BaseFooServiceImpl;

import com.test.model.Foo;

@Service
public class FooServiceImpl
  extends BaseFooServiceImpl<Foo,Long>
  implements FooService
{
}