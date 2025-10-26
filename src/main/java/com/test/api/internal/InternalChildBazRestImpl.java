package com.test.api.internal;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.api.base.internal.BaseInternalChildBazRestImpl;

@RestController
@RequestMapping("/api/internal")
public class InternalChildBazRestImpl
   extends BaseInternalChildBazRestImpl
   implements InternalChildBazRest
{
}