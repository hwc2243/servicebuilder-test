package com.test.service;

import org.springframework.stereotype.Service;

import com.test.service.base.BaseOneToOneOwnedUnidirectionalServiceImpl;

import com.test.model.OneToOneOwnedUnidirectional;

@Service
public class OneToOneOwnedUnidirectionalServiceImpl
  extends BaseOneToOneOwnedUnidirectionalServiceImpl<OneToOneOwnedUnidirectional,Long>
  implements OneToOneOwnedUnidirectionalService
{
}