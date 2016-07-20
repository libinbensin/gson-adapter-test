package com.libin.gsontest;

import com.google.gson.annotations.JsonAdapter;

/**
 * @author Libin
 */
@JsonAdapter(TestClassAAdapter.class)
public class TestClassA {

    String name;

    @JsonAdapter(TestClassBAdapter.class)
    TestClassB testB;

    String unitNumber;

    String addressLine2;

}
