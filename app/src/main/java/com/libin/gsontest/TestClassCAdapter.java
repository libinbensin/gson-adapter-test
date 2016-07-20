package com.libin.gsontest;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * @author Libin
 */
public class TestClassCAdapter extends TypeAdapter<TestClassC> {
    @Override
    public void write(JsonWriter out, TestClassC value) throws IOException {
        out.beginObject();
        out.name("name").value(value.name);
        out.endObject();
    }

    @Override
    public TestClassC read(JsonReader in) throws IOException {
        if(in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        in.beginObject();
        TestClassC testClassC = new TestClassC();
        in.nextName();
        testClassC.name = in.nextString();
        in.endObject();
        return testClassC;
    }
}
