package com.JAVA8;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        // of - Creates an Optional with a non-null value. Throws NullPointerException if the value is null.
        Optional<String> nonEmptyOptional = Optional.of("Hello");
        System.out.println("Optional.of(\"Hello\"): " + nonEmptyOptional);

        // ofNullable - Creates an Optional that can hold a null value.
        Optional<String> nullableOptional = Optional.ofNullable(null);
        System.out.println("Optional.ofNullable(null): " + nullableOptional);

        Optional<String> nonNullNullableOptional = Optional.ofNullable("World");
        System.out.println("Optional.ofNullable(\"World\"): " + nonNullNullableOptional);

        // empty - Creates an empty Optional.
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("Optional.empty(): " + emptyOptional);

        // isPresent - Checks if the Optional contains a value.
        System.out.println("nonEmptyOptional.isPresent(): " + nonEmptyOptional.isPresent());
        System.out.println("emptyOptional.isPresent(): " + emptyOptional.isPresent());

        // ifPresent - Executes the given code block if a value is present.
        nonEmptyOptional.ifPresent(value -> System.out.println("ifPresent executed for: " + value));
        emptyOptional.ifPresent(value -> System.out.println("ifPresent executed for: " + value)); // This won't be printed

        // orElse - Returns the value if present, otherwise returns the default value.
        System.out.println("orElse on non-empty Optional: " + nonEmptyOptional.orElse("Default"));
        System.out.println("orElse on empty Optional: " + emptyOptional.orElse("Default"));

        // orElseGet - Returns the value if present, otherwise returns the result of the given supplier.
        System.out.println("orElseGet on non-empty Optional: " + nonEmptyOptional.orElseGet(() -> "Default from Supplier"));
        System.out.println("orElseGet on empty Optional: " + emptyOptional.orElseGet(() -> "Default from Supplier"));

        // orElseThrow - Returns the value if present, otherwise throws an exception.
        try {
            System.out.println("orElseThrow on non-empty Optional: " + nonEmptyOptional.orElseThrow(IllegalArgumentException::new));
            System.out.println("orElseThrow on empty Optional: " + emptyOptional.orElseThrow(IllegalArgumentException::new));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown by orElseThrow on empty Optional.");
        }

        // get - Returns the value if present, otherwise throws NoSuchElementException.
        System.out.println("get on non-empty Optional: " + nonEmptyOptional.get());
        try {
            System.out.println("get on empty Optional: " + emptyOptional.get());
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Exception thrown by get on empty Optional.");
        }

        // filter - If a value is present and matches the given predicate, returns an Optional describing the value, otherwise returns an empty Optional.
        System.out.println("filter on non-empty Optional (match): " + nonEmptyOptional.filter(s -> s.startsWith("H")));
        System.out.println("filter on non-empty Optional (no match): " + nonEmptyOptional.filter(s -> s.startsWith("W")));
        System.out.println("filter on empty Optional: " + emptyOptional.filter(s -> s.startsWith("H")));

        // map - If a value is present, applies the provided mapping function to it.
        System.out.println("map on non-empty Optional: " + nonEmptyOptional.map(String::toUpperCase));
        System.out.println("map on empty Optional: " + emptyOptional.map(String::toUpperCase));

        // flatMap - If a value is present, applies the provided Optional-bearing mapping function to it.
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("nested"));
        System.out.println("flatMap on nested Optional: " + nestedOptional.flatMap(o -> o));
    }
}
