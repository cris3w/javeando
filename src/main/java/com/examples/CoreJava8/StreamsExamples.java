package com.examples.CoreJava8;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Streams in Java 8
// http://www.baeldung.com/java-8-streams-introduction
// http://www.baeldung.com/java-8-streams
// - streams functionality contains classes for processing sequences of elements

class StreamsCreation {

    public void showExamples() {

        // Empty Stream

        Stream<String> streamEmpty = Stream.empty();
        System.out.println(streamEmpty.collect(Collectors.toList())); // []

        // to avoid returning null for streams with no element
        Stream<String> streamOfNull = streamOf(null);
        Stream<String> streamOfEmptyList = streamOf(new ArrayList<String>());
        Stream<String> streamOfList = streamOf(Arrays.asList("a", "b", "c"));
        System.out.println(streamOfNull.collect(Collectors.toList())); // []
        System.out.println(streamOfEmptyList.collect(Collectors.toList())); // []
        System.out.println(streamOfList.collect(Collectors.toList())); // [a, b, c]

        // Stream of Collection

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        System.out.println(streamOfCollection.collect(Collectors.toList())); // [a, b, c]

        // Stream of Array

        Stream<String> streamOfArray = Stream.of("a", "b", "c");
        System.out.println(streamOfArray.collect(Collectors.toList())); // [a, b, c]

        // of an existing array or of a part of an array
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        System.out.println(streamOfArrayFull.collect(Collectors.toList())); // [a, b, c]
        System.out.println(streamOfArrayPart.collect(Collectors.toList())); // [a, b]

        // Stream builder

        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
        System.out.println(streamBuilder.collect(Collectors.toList())); // [a, b, c]

        // Stream generate

        Stream<String> streamGenerated = Stream.generate(() -> "elem").limit(3);
        // resulting stream is infinite, so developer should specify the desired size
        System.out.println(streamGenerated.collect(Collectors.toList())); // [elem, elem, elem]

        // Stream iterate

        Stream<Integer> streamIterated = Stream.iterate(10, n -> n + 2).limit(6);
        System.out.println(streamIterated.collect(Collectors.toList())); // [10, 12, 14, 16, 18, 20]

        // Stream of Primitives

        // Stream of String

        // Stream of File

    }

    private Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
}

class StreamsOperations {

    // - They are divided into intermediate operations (return Stream<T>) and terminal operations (return a result of definite type)
    // - The operations on streams don't change the source

    public void showExamples() {

        // ITERATING
        // Stream API helps to substitute for, for-each and while loops

        List<String> list = Arrays.asList("a", "b", "c");
        /* for-loop:
        for (String string: list) {
            if (string.contains("a")) { return true; }
        }*/
        boolean isExist = list.stream().anyMatch(elem -> elem.contains("a"));
        System.out.println(isExist); // true

        // FILTERING: filter()
        // - picks up elements which satisfy a predicate

        List<String> countries = Arrays.asList("Italy", "Spain", "Denmark", "Russia", "France");
        Stream<String> countriesWithE = countries.stream().filter(country -> country.contains("e"));
        System.out.println(countriesWithE.collect(Collectors.toList())); // [Denmark, France]

        // MAPPING: map(), flatMap()
        // - converts elements applying a special function to them

        // map:
        List<String> uris = Arrays.asList("C:\\\\My.txt");
        Stream<Path> paths = uris.stream().map(uri -> Paths.get(uri));
        System.out.println(paths.collect(Collectors.toList())); // [C:\\My.txt]

        // flatMap:
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("a", "A"), Arrays.asList("b", "B"));
        Stream<String> streamPlain = listOfLists.stream().flatMap(Collection::stream); // innerList -> innerList.stream()
        System.out.println(streamPlain.collect(Collectors.toList())); // [a, A, b, B]

        // MATCHING: anyMatch(), allMatch(), noneMatch()
        // - validates elements according to some predicate

        boolean isValidAny = countries.stream().anyMatch(elem -> elem.contains("n"));
        boolean isValidAll = countries.stream().allMatch(elem -> elem.contains("a"));
        boolean isValidNone = countries.stream().noneMatch(elem -> elem.contains("x"));
        System.out.println(String.format("%s %s %s",
                String.valueOf(isValidAny),
                String.valueOf(isValidAll),
                String.valueOf(isValidNone))); // true true true

        // REDUCTION: reduce()
        // - reduces the elements to some value according to a specified function

        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer sum = integers.stream().reduce(2, (a, b) -> a + b);
        System.out.println(sum); // 5

        // COLLECTING: collect()
        // The reduction can also be provided by the collect() method

        List<String> upperCase = list.stream().map(String::toUpperCase).collect(Collectors.toList()); // elem -> elem.toUpperCase()
        System.out.println(upperCase); // [A, B, C]
    }
}

public class StreamsExamples {

    public static void main(String[] args) {
        StreamsCreation creation = new StreamsCreation();
        StreamsOperations operations = new StreamsOperations();

        creation.showExamples();
        operations.showExamples();
    }
}
