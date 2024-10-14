package com.test.service;

import org.springframework.stereotype.Service;

import com.test.service.base.BaseChildBazServiceImpl;

import com.test.model.ChildBaz;

@Service
public class ChildBazServiceImpl
  extends BaseChildBazServiceImpl<ChildBaz,Long>
  implements ChildBazService
{
}