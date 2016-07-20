package com.libin.gsontest;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void testToJSONJsonAdapter(){

        String response = "{\"name\":\"hello\",\"testB\":\"{\\\"name\\\":\\\"Hello test B\\\"}\",\"UnitNumber\":\"100\",\"AddressLine2\":\"100\"}";

        TestClassA testClassA = new TestClassA();
        testClassA.name = "hello";

        TestClassB testClassB = new TestClassB();
        testClassB.name = "Hello test B";
        testClassA.testB = testClassB;
        testClassA.unitNumber = "100";

        Gson gson = new Gson();
        String toJson = gson.toJson(testClassA, TestClassA.class);
        assertEquals(toJson , response);
    }

    @Test
    public void testToJSONAddressLine2JsonAdapter(){

        String response = "{\"name\":\"hello\",\"testB\":\"{\\\"name\\\":\\\"Hello test B\\\"}\",\"AddressLine2\":\"100\"}";

        TestClassA testClassA = new TestClassA();
        testClassA.name = "hello";

        TestClassB testClassB = new TestClassB();
        testClassB.name = "Hello test B";
        testClassA.testB = testClassB;
        testClassA.addressLine2 = "100";

        Gson gson = new Gson();
        String toJson = gson.toJson(testClassA, TestClassA.class);
        assertEquals(toJson , response);
    }

    @Test
    public void testFromJSONJsonAdapter(){

        String response = "{\"name\":\"hello\",\"testB\":\"{\\\"name\\\":\\\"Hello test B\\\"}\",\"UnitNumber\":\"100\",\"AddressLine2\":\"100\"}";

        Gson gson = new Gson();
        TestClassA testClassA = gson.fromJson(response, TestClassA.class);
        assertNotNull(testClassA);
        assertNotNull(testClassA.testB);
        assertEquals(testClassA.testB.name , "Hello test B");
        assertEquals(testClassA.unitNumber , "100");
        assertEquals(testClassA.addressLine2 , "100");
    }

    @Test
    public void testFromJSONAddressLine2JsonAdapter(){

        String response = "{\"name\":\"hello\",\"testB\":\"{\\\"name\\\":\\\"Hello test B\\\"}\",\"AddressLine2\":\"100\"}";

        Gson gson = new Gson();
        TestClassA testClassA = gson.fromJson(response, TestClassA.class);
        assertNotNull(testClassA);
        assertNotNull(testClassA.testB);
        assertEquals(testClassA.testB.name , "Hello test B");
        assertNull(testClassA.unitNumber);
        assertEquals(testClassA.addressLine2 , "100");
    }

    @Test
    public void testToJSONInnerListObjectJsonAdapter(){

        String response = "{\"name\":\"hello\",\"testB\":\"{\\\"name\\\":\\\"Hello test B\\\",\\\"classC\\\":[{\\\"name\\\":\\\"Hello class C \\\"}]}\",\"UnitNumber\":\"100\",\"AddressLine2\":\"100\"}";

        TestClassA testClassA = new TestClassA();
        testClassA.name = "hello";

        TestClassB testClassB = new TestClassB();
        testClassB.name = "Hello test B";
        testClassA.testB = testClassB;
        testClassA.unitNumber = "100";
        testClassB.testClassCList = new ArrayList<>();

        TestClassC testClassC = new TestClassC();
        testClassC.name = "Hello class C ";
        testClassB.testClassCList.add(testClassC);

        Gson gson = new Gson();
        String toJson = gson.toJson(testClassA, TestClassA.class);
        assertEquals(toJson , response);
    }

    @Test
    public void testFromJSONInnerListObjectJsonAdapter(){

        String response = "{\"name\":\"hello\",\"testB\":\"{\\\"name\\\":\\\"Hello test B\\\",\\\"classC\\\":[{\\\"name\\\":\\\"Hello class C \\\"}]}\",\"UnitNumber\":\"100\",\"AddressLine2\":\"100\"}";

        Gson gson = new Gson();
        TestClassA testClassA = gson.fromJson(response, TestClassA.class);
        assertNotNull(testClassA);
        assertNotNull(testClassA.testB);
        assertEquals(testClassA.testB.name , "Hello test B");
        assertEquals(testClassA.unitNumber , "100");
        assertEquals(testClassA.addressLine2 , "100");
        assertNotNull(testClassA.testB.testClassCList);
        assertFalse(testClassA.testB.testClassCList.isEmpty());
        assertNotNull(testClassA.testB.testClassCList.get(0));
        assertEquals(testClassA.testB.testClassCList.get(0).name , "Hello class C ");
    }
}
