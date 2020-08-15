package com.pjh.example.functional;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Create by : pjh
 * email : junghun5947@gmail.com
 */
public class LazyEvaluation {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        printIfValidIndex(0, getVeryExpensiveValue());
        printIfValidIndex(-1, getVeryExpensiveValue());
        printIfValidIndex(-3, getVeryExpensiveValue());
        System.out.println("It took " + ((System.currentTimeMillis() - startTime) / 1000));

        startTime = System.currentTimeMillis();
        printIfValidIndexWithSupplier(0, () -> getVeryExpensiveValue());
        printIfValidIndexWithSupplier(-1, () -> getVeryExpensiveValue());
        printIfValidIndexWithSupplier(-3, () -> getVeryExpensiveValue());
        System.out.println("It took " + ((System.currentTimeMillis() - startTime) / 1000));
    }

    private static String getVeryExpensiveValue() {
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "PJH";
    }

    //number 조건이 맞지 않아도 getVeryExpensiveValue method를 parameter 로 전달하기 위해 호출함
    private static void printIfValidIndex(int number, String value){
        if(number >= 0)
            System.out.println("value : " + number);
        else
            System.out.println("Invalid");
    }

    //number 조건이 맞지않을때 불필요한 getVeryExpensiveValue method 호출을 하지 않음
    private static void printIfValidIndexWithSupplier(int number, Supplier<String> valueSupplier){
        if(number >= 0)
            System.out.println("value : " + number);
        else
            System.out.println("Invalid");
    }
}
