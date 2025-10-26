package com.test.api.internal;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.api.base.internal.BaseInternalOneToManyBarRestImpl;

@RestController
@RequestMapping("/api/internal")
public class InternalOneToManyBarRestImpl
   extends BaseInternalOneToManyBarRestImpl
   implements InternalOneToManyBarRest
{
}