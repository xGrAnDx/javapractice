package ru.grand.lesson8;

import java.util.LinkedList;

public class PersonCollection extends LinkedList<Person> {

    public void print() {
        this.stream().forEach(System.out::println);
    }
}
