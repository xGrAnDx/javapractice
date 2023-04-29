package ru.grand.HW3;

import java.util.ArrayList;
import java.util.List;

public class HW3 {
    public static void main(String[] args) {

        var persons = initPersonList();

        persons.stream().filter(x -> x.getAge() >= 40).forEach(x -> System.out.println(x));
    }

    public static List<Person> initPersonList()
    {
        var persons = new ArrayList<Person>();
        persons.add(new Person(
                "Stephen Strange","Sorcerer Supreme",
                "drmrstrange@agamoto.com",
                1,
                41));
        persons.add(new Person(
                "Tony Stark","Stark Industries CEO",
                "iamironman@starkin.com",
                10000,
                40));

        persons.add(new Person(
                "Thor Odinson","Ruler of Asgard",
                "thunderlord@asgard.com",
                5000,
                35));

        persons.add(new Person(
                "Wanda Maximoff","Scarlet Witch",
                "chaosgirl@darkhold.com",
                5000,
                26));

        persons.add(new Person(
                "Peter Parker","Spider-man",
                "pparker@mit.com",
                6000,
                22));

        return persons;
    }
}
