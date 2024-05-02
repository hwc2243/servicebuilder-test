package com.test.service;

import org.springframework.stereotype.Service;

import com.test.base.service.BaseOneToOneOwnerUnidirectionalServiceImpl;

import com.test.model.OneToOneOwnerUnidirectional;

@Service
public class OneToOneOwnerUnidirectionalServiceImpl
  extends BaseOneToOneOwnerUnidirectionalServiceImpl<OneToOneOwnerUnidirectional,Long>
  implements OneToOneOwnerUnidirectionalService
{
}