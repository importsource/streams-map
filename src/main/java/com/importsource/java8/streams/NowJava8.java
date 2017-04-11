package com.importsource.java8.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NowJava8 {

    public static void main(String[] args) {

        List<Staff> staff = Arrays.asList(
                new Staff("importsource", 30, new BigDecimal(10000)),
                new Staff("messi", 27, new BigDecimal(20000)),
                new Staff("xavi", 33, new BigDecimal(30000))
        );

		// convert inside the map() method directly.
        List<StaffPublic> result = staff.stream().map(temp -> {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("importsource".equals(temp.getName())) {
                obj.setExtra("this field is for importsource only!");
            }
            return obj;
        }).collect(Collectors.toList());

        System.out.println(result);

    }

}
