package com.pjh.example.stream;

import java.util.Arrays;
import java.util.List;

public class Filter {
    public static void main(final String[] args){
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(regacyFilter(numbers));
        System.out.println(streamFilter(numbers));
    }

    static Integer regacyFilter(List<Integer> numbers){
        Integer result = null;

        for(final Integer i : numbers){
            if(i > 3 &&  i < 9 ){
                final Integer newNumber = i * 2;
                if(newNumber > 10){
                    result = newNumber;
                    break;
                }
            }
        }
        return result;
    }

    static Integer streamFilter(List<Integer> numbers){
        return numbers.stream()
                .filter( i -> i > 3) // ->
                .filter( i -> i < 9) //
                .map( i -> i * 2)    //
                .filter( i -> i > 10)// -> Intermediate Operation Method
                .findFirst() // Terminal Operation Method
                .get(); // Terminal
    }
}
