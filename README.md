# gson-adapter-test
This is sample project to test the JsonAdapter annotation on GSON library to serialize/deserialize models using custom type adapters

This example has three model classes and the objects on the models are using custom Json Adapters (@JsonAdapter)


# Create a test class A
     @JsonAdapter(TestClassAAdapter.class)
     public class TestClassA {
      String name;
      @JsonAdapter(TestClassBAdapter.class)
      TestClassB testB;
      String unitNumber;
      String addressLine2;
    }


# Create a test class B
     public class TestClassB {
       String name;
       @SerializedName("classC")
       List<TestClassC> testClassCList;
     }

# Create a test class C
    @JsonAdapter(TestClassCAdapter.class)
    public class TestClassC {
     String name;
    }


#Finally , create custom adapters
    
    public class TestClassAAdapter extends TypeAdapter<TestClassA>{
    @Override
    public void write(JsonWriter out, TestClassA value) throws IOException {
        out.beginObject();
        out.name("name").value(value.name);
        out.name("testB").value(new Gson().toJson(value.testB));
        if(value.unitNumber !=null && value.unitNumber.length() > 0) {
            out.name("UnitNumber").value(value.unitNumber);
            out.name("AddressLine2").value(value.unitNumber);
        }else {
            out.name("AddressLine2").value(value.addressLine2);
        }
        out.endObject();
    }

    @Override
    public TestClassA read(JsonReader in) throws IOException {
        if(in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        in.beginObject();
        TestClassA testClassA = new TestClassA();
        in.nextName();
        testClassA.name = in.nextString();
        in.nextName();
        testClassA.testB = new Gson().fromJson(in.nextString(), TestClassB.class);
        while (in.hasNext()) {
            String name = in.nextName();
            if(name.equals("UnitNumber")){
                testClassA.unitNumber = in.nextString();
            }else if(name.equals("AddressLine2")){
                testClassA.addressLine2 = in.nextString();
            }
        }
        in.endObject();
        return testClassA;
    }
    }






