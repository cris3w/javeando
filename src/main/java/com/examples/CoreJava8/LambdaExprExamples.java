package com.examples.CoreJava8;

import java.util.function.Function;

/*
@FunctionalInterface
public interface Foo {

    String concat(String string);
}
*/

class FooImp {

    /*
    public String concat(String string, Foo foo) {
        return foo.concat(string);
    }
    */

    public String concat(String string, Function<String, String> fn) {
        return fn.apply(string);
    }
}

public class LambdaExprExamples {

    public static void main(String[] args) {
        FooImp foo = new FooImp();

        String res = foo.concat("Msg ", s -> s + "from lambda");
        System.out.println(res);
    }
}

// Lambda Expressions and Functional Interfaces: Tips and Best Practices
// http://www.baeldung.com/java-8-lambda-expressions-tips
// - Prefer standard Functional Interfaces
// - Use @FunctionalInterface annotation
// - Don’t overuse default methods in Functional Interfaces
// - Instantiate Functional Interfaces with Lambda Expressions
// - Avoid overloading methods with Functional Interfaces as parameters
// - Don’t treat Lambda Expressions as inner classes
// - Keep Lambda Expressions short and self-explanatory
// - Use “Effectively Final" variables
// - Protect object Variables from mutation

