package com.test.service;

import org.springframework.stereotype.Service;

import com.test.base.service.BaseManyToManyBarServiceImpl;

import com.test.model.ManyToManyBar;

@Service
public class ManyToManyBarServiceImpl
  extends BaseManyToManyBarServiceImpl<ManyToManyBar,Long>
  implements ManyToManyBarService
{
}