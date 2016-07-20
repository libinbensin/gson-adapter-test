package com.libin.gsontest;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * @author Libin
 */
public class TestClassBAdapter extends TypeAdapter<TestClassB>{
    @Override
    public void write(JsonWriter out, TestClassB value) throws IOException {
        out.beginObject();
        out.name("name").value(value.name);
        out.endObject();
    }

    @Override
    public TestClassB read(JsonReader in) throws IOException {
        if(in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        in.beginObject();
        TestClassB testClassB = new TestClassB();
        testClassB.name = in.nextString();
        in.endObject();
        return testClassB;
    }
}
