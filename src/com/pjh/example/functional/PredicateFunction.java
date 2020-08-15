package com.pjh.example.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Create by : pjh
 * email : junghun5947@gmail.com
 */
public class PredicateFunction {
    public static void main(String[] args){
        Predicate<Integer> lessThan3 =  number -> number < 3;
        Predicate<Integer> moreThan3 =  number -> number > 3;

        List<Integer> IntegerArray = Arrays.asList(1,2,3,4,1,2,3,5,6,3,1,2);

        filter(IntegerArray, lessThan3).forEach( i -> System.out.print(i + " "));
        System.out.println("");
        filter(IntegerArray, moreThan3).forEach( i -> System.out.print(i + " "));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filterFunction){
        List<T> resultArrays = new ArrayList<>();
        for(T value : list){
            if(filterFunction.test(value)) {
                resultArrays.add(value);
            }
        }
        return resultArrays;
    }
}
