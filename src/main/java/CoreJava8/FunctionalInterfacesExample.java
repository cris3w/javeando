package CoreJava8;

// Functional Interfaces in Java 8
// http://www.baeldung.com/java-8-functional-interfaces
// - A lambda is an anonymous function that can be handled as a first-class language citizen,
//   for instance passed to or returned from a method
// - @FunctionalInterface annotation allows a compiler to generate an error if the annotated
//   interface does not satisfy the conditions. Any interface with only one SAM (Single Abstract Method)
//   is a functional interface, and its implementation may be treated as lambda expressions. Default methods
//   are not abstract and do not count: a functional interface may still have multiple default methods

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfacesExample {

    public static void main(String[] args) {
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("Laura", 20000);
        salaries.put("Ana", 50000);
        salaries.put("Sarah", 30000);
        List<String> names = Arrays.asList("Laura", "Ana", "Sarah");

        // FUNCTIONS
        // - receive one value and return another

        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("Ana", String::length); // nameMap.computeIfAbsent("Ana", s -> s.length());
        System.out.println(value); // 3

        // have a default compose() method that allows to combine several:
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        System.out.println(quoteIntToString.apply(5)); // '5'

        // PRIMITIVE FUNCTION SPECIALIZATIONS
        // - versions of the Function interface for most used primitive types
        // There are also specialized versions of Supplier, Consumer, Predicate, UnaryOperator and BinaryOperator

        // TWO-ARITY FUNCTION SPECIALIZATIONS
        // - lambdas with two arguments

        salaries.replaceAll((name, oldValue) ->
                name.equals("Ana") ? oldValue : oldValue + 10000);
        salaries.forEach((n, s) -> System.out.println(n + " " + s)); // Laura 30000 \n Ana 50000 \n Sarah 40000

        // SUPPLIERS
        // - not take any arguments

        Supplier<Integer> number = () -> 100; // () -> { return 100; };
        Double pow = Math.pow(number.get(), 2);
        System.out.println(pow); // 10000

        // CONSUMERS
        // - accept an arguments and return nothing

        names.forEach(n -> System.out.println("Hola, " + n)); // Hola, Laura \n Hola Pedro \n Hola Sarah

        // PREDICATES
        // - receive a value and return a boolean value

        List<String> namesWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(namesWithA); // [Ana]

        // OPERATORS
        // - receive and return the same value type

        // UnaryOperator:
        names.replaceAll(String::toUpperCase); // names.replaceAll(name -> name.toUpperCase());
        names.forEach(System.out::println); // LAURA \n ANA \n SARAH

        // BinaryOperator:
        List<Integer> values = Arrays.asList(1, 3, 4, 7);
        int sum = values.stream()
                .reduce(0, (i1, i2) -> i1 + i2);
        System.out.println(sum); // 15

        // LEGACY FUNCTIONAL INTERFACES
        // Not all functional interfaces appeared in Java 8. Many interfaces from previous versions of Java
        // conform to the constraints of a FunctionalInterface and can be used as lambdas
    }
}
