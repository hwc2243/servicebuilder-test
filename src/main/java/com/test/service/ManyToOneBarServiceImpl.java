package com.test.service;

import org.springframework.stereotype.Service;

import com.test.base.service.BaseManyToOneBarServiceImpl;

import com.test.model.ManyToOneBar;

@Service
public class ManyToOneBarServiceImpl
  extends BaseManyToOneBarServiceImpl<ManyToOneBar,Long>
  implements ManyToOneBarService
{
}