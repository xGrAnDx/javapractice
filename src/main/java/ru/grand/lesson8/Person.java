package ru.grand.lesson8;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Person {

    @Getter
    private int age;
    @Getter
    private String lastName;

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %s", lastName, age);
    }
}
