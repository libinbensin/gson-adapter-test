package com.libin.gsontest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Libin
 */
public class TestClassB {

    String name;
    @SerializedName("classC")
    List<TestClassC> testClassCList;
}
