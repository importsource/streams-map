package com.importsource.java8.streams;

import com.importsource.onetest.After;
import com.importsource.onetest.Function;
import com.importsource.onetest.OneTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hezhuofan
 */
public class PerformanceTest {

    public static void main(String[] args) {
        List<com.importsource.java8.streams.Staff> staff = Arrays.asList(
                new com.importsource.java8.streams.Staff("importsource", 30, new BigDecimal(10000)),
                new com.importsource.java8.streams.Staff("messi", 27, new BigDecimal(20000)),
                new com.importsource.java8.streams.Staff("xavi", 33, new BigDecimal(30000))
        );


       // beforeJava8(staff);
       // nowJava8(staff);


        OneTest oneTest = new OneTest("Redis get(1byte)", 100);

        Function function = new Function() {
            public void function(Object args) {
                //beforeJava8(staff);
                nowJava8(staff);
            }
        };
        After after = new After() {
            public void after(Object args) {
            }
        };

        oneTest.setFunction(function);
        oneTest.setAfter(after);
        oneTest.start();
    }

    private static void nowJava8(List<Staff> staff) {
        //Java 8
        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect); //[importsource, messi, xavi]
    }

    private static void beforeJava8(List<Staff> staff) {
        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staff) {
            result.add(x.getName());
        }
        System.out.println(result); //[importsource, messi, xavi]
    }
}





