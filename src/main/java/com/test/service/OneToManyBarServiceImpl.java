package com.test.service;

import org.springframework.stereotype.Service;

import com.test.service.base.BaseOneToManyBarServiceImpl;

import com.test.model.OneToManyBar;

@Service
public class OneToManyBarServiceImpl
  extends BaseOneToManyBarServiceImpl<OneToManyBar,Long>
  implements OneToManyBarService
{
}