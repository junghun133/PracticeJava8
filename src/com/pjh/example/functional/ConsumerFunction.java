package com.pjh.example.functional;

import java.util.function.Consumer;

public class ConsumerFunction {

    private static void consumerExamples() {

        final Consumer<String> print = value -> System.out.println(value);
        print.accept("Hello");

        final Consumer<String> greetings = value -> System.out.println("Hello " + value);
        greetings.accept("World");
        greetings.accept("JungHoon");
    }

    public static void main(final String[] args) {
        consumerExamples();
    }
}
