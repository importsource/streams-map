package com.importsource.java8.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeforeJava8 {

    public static void main(String[] args) {

        List<Staff> staff = Arrays.asList(
                new Staff("importsource", 30, new BigDecimal(10000)),
                new Staff("messi", 27, new BigDecimal(20000)),
                new Staff("xavi", 33, new BigDecimal(30000))
        );

        List<StaffPublic> result = convertToStaffPublic(staff);
        System.out.println(result);

    }

    private static List<StaffPublic> convertToStaffPublic(List<Staff> staff) {

        List<StaffPublic> result = new ArrayList<>();

        for (Staff temp : staff) {

            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("importsource".equals(temp.getName())) {
                obj.setExtra("this field is for importsource only!");
            }

            result.add(obj);
        }

        return result;

    }

}
