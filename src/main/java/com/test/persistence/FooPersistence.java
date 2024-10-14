package com.test.persistence;

import com.test.model.Foo;

import com.test.persistence.base.BaseFooPersistence;

public interface FooPersistence extends BaseFooPersistence<Foo,Long>
{
} 