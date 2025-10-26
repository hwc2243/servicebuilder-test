package com.test.api.internal;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.api.base.internal.BaseInternalManyToOneBarRestImpl;

@RestController
@RequestMapping("/api/internal")
public class InternalManyToOneBarRestImpl
   extends BaseInternalManyToOneBarRestImpl
   implements InternalManyToOneBarRest
{
}