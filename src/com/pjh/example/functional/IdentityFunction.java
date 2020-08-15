package com.pjh.example.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Create by : pjh
 * email : junghun5947@gmail.com
 */
public class IdentityFunction {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5 , 6);
        System.out.println("map (numbers, i -> i * 2)");
        System.out.println(map(numbers, i -> i * 2));

        // map 기능이 필요 없을 때 null로 구분하고 싶다
        System.out.println("map (numbers, null)");
        System.out.println(map(numbers, i -> i));
        System.out.println(map(numbers, Function.identity()));
    }

    private static <T, R> List<R> map(final List<T> list, final Function<T, R> mapper){
        List<R> result = new ArrayList<>();
        for(final T t : list){
            result.add(mapper.apply(t));
        }
        return result;
    }
}
