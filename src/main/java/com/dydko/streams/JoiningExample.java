package com.dydko.streams;

import com.dydko.funcprogramming.Instructor;
import com.dydko.funcprogramming.Instructors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningExample {
    public static void main(String[] args) {
        String result = Stream.of("E","F", "G", "H").collect(Collectors.joining());
        System.out.println(result);

        result = Stream.of("E","F","G","H").collect(Collectors.joining(","));
        System.out.println(result);

        result = Stream.of ("E", "F", "G", "H").collect(Collectors.
                joining(",","{","}" ));
        System.out.println(result);

        //instructors names seperated by ' and prefix { and suffix }
        String namesConcatenated = Instructors.getAll().stream()
                            .map(Instructor::getName)
                            .collect(Collectors.joining(",","{", "}"));
        System.out.println("namesConcatenated = " + namesConcatenated);

    }
}
