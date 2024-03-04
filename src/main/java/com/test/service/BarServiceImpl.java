package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.base.service.BaseBarServiceImpl;
import com.test.base.service.ServiceException;
import com.test.model.Bar;

@Service
public class BarServiceImpl
  extends BaseBarServiceImpl<Bar,Long>
  implements BarService
{
}