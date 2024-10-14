package com.test.service;

import org.springframework.stereotype.Service;

import com.test.service.base.BaseOneToOneBidirectionalBarServiceImpl;

import com.test.model.OneToOneBidirectionalBar;

@Service
public class OneToOneBidirectionalBarServiceImpl
  extends BaseOneToOneBidirectionalBarServiceImpl<OneToOneBidirectionalBar,Long>
  implements OneToOneBidirectionalBarService
{
}