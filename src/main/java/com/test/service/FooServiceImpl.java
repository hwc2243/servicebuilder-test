package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.base.service.BaseFooServiceImpl;
import com.test.base.service.ServiceException;
import com.test.model.Foo;

@Service
public class FooServiceImpl
  extends BaseFooServiceImpl<Foo,Long>
  implements FooService
{
}