package com.libin.gsontest;

import com.google.gson.annotations.JsonAdapter;

/**
 * @author Libin
 */
@JsonAdapter(TestClassCAdapter.class)
public class TestClassC {
    String name;
}
