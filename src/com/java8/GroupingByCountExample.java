package com.java8;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GroupingByCountExample {
	public static void main(String... args) {
		java.util.List<String> strings = Arrays.asList("Zohne", "Redy", "Zohne", "Redy", "Stome");
		
		java.util.Map<String, Long> nameCount = strings.stream()
				.collect(Collectors.groupingBy(string -> string, Collectors.counting()));
		
		nameCount.forEach((name, count) -> {
			System.out.println(name + ":" + count);
		});
	}
}

/*
java.util.List<Employee> employees = Employee.getEmployee();
       java.util.Map<String, Integer> designationWiseTotalSalary = employees.stream().collect(Collectors
               .groupingBy(Employee::getDesignation, Collectors.summingInt(Employee::getSalary)));
       designationWiseTotalSalary.forEach((k, v) -> {
           System.out.println(k + " : " + v);
       });
       
       java.util.List<Employee> employees = Employee.getEmployee();
        java.util.Map<String, Double> designationWiseEvgSalary = employees.stream().collect(Collectors
                .groupingBy(Employee::getDesignation, Collectors.averagingLong(Employee::getSalary)));
        designationWiseEvgSalary.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
        
        
*/