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
public class ListDemo {

    public static void main(String[] args) {
        List<Staff> staff = Arrays.asList(
                new Staff("importsource", 30, new BigDecimal(10000)),
                new Staff("messi", 27, new BigDecimal(20000)),
                new Staff("xavi", 33, new BigDecimal(30000))
        );

        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staff) {
            result.add(x.getName());
        }
        System.out.println(result); //[importsource, messi, xavi]

        //Java 8
        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect); //[importsource, messi, xavi]


    }
}

 class Staff {

    private String name;
    private int age;
    private BigDecimal salary;

    public Staff(String name,int age,BigDecimal salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }

     public String getName() {
         return name;
     }

     public Staff setName(String name) {
         this.name = name;
         return this;
     }

     public int getAge() {
         return age;
     }

     public Staff setAge(int age) {
         this.age = age;
         return this;
     }

     public BigDecimal getSalary() {
         return salary;
     }

     public Staff setSalary(BigDecimal salary) {
         this.salary = salary;
         return this;
     }
 }

class StaffPublic{

    private String name;
    private int age;
    private String extra;

    public StaffPublic(String name,int age,String extra){
        this.name=name;
        this.age=age;
        this.extra=extra;
    }

    public StaffPublic() {

    }

    public String getName() {
        return name;
    }

    public StaffPublic setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StaffPublic setAge(int age) {
        this.age = age;
        return this;
    }


    public String getExtra() {
        return extra;
    }

    public StaffPublic setExtra(String extra) {
        this.extra = extra;
        return this;
    }


}
