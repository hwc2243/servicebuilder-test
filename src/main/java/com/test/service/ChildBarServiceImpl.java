package com.test.service;

import org.springframework.stereotype.Service;

import com.test.service.base.BaseChildBarServiceImpl;

import com.test.model.ChildBar;

@Service
public class ChildBarServiceImpl
  extends BaseChildBarServiceImpl<ChildBar,Long>
  implements ChildBarService
{
}