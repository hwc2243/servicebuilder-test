package com.test.service;

import org.springframework.stereotype.Service;

import com.test.service.base.BaseManyToOneBarServiceImpl;

import com.test.model.ManyToOneBar;

@Service
public class ManyToOneBarServiceImpl
  extends BaseManyToOneBarServiceImpl<ManyToOneBar,Long>
  implements ManyToOneBarService
{
}