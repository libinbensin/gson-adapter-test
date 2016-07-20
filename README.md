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






