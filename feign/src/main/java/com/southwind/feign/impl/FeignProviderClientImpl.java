package com.southwind.feign.impl;

import com.southwind.entity.Student;
import com.southwind.feign.FeignProviderClient;

import java.util.Collection;

public class FeignProviderClientImpl implements FeignProviderClient {

    @Override
    public Collection<Student> finAll() {
        return null;
    }

    @Override
    public String index() {
        return null;
    }
}
