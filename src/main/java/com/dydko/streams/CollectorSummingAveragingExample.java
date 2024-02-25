package com.dydko.streams;

import com.dydko.funcprogramming.Instructor;
import com.dydko.funcprogramming.Instructors;

import java.util.stream.Collectors;

public class CollectorSummingAveragingExample {
    public static void main(String[] args) {
        //sum of years of experience of all instructor
        int sum = Instructors.getAll().stream()
                .collect(Collectors.summingInt(Instructor::getYearsOfExperience));

        System.out.println("sum = " + sum);
        
        //calculate average of years of experience of all instructors
        double average = Instructors.getAll().stream()
                .collect(Collectors.averagingInt(Instructor::getYearsOfExperience));

        System.out.println("average = " + average);
        
        
    }
}
