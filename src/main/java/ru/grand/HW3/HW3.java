package ru.grand.HW3;

public class HW3 {
    public static void main(String[] args) {

        var persons = InitPersonList();

        for(Person p: persons)
        {
            if (p.getAge() >= 40)
            {
                System.out.println(p);
            }
        }

    }

    public static Person[] InitPersonList()
    {
        var array = new Person[5];
        array[0] = new Person(
                "Stephen Strange","Sorcerer Supreme",
                "drmrstrange@agamoto.com",
                1,
                41);
        array[1] = new Person(
                "Tony Stark","Stark Industries CEO",
                "iamironman@starkin.com",
                10000,
                40);

        array[2] = new Person(
                "Thor Odinson","Ruler of Asgard",
                "thunderlord@asgard.com",
                5000,
                35);

        array[3] = new Person(
                "Wanda Maximoff","Scarlet Witch",
                "chaosgirl@darkhold.com",
                5000,
                26);

        array[4] = new Person(
                "Peter Parker","Spider-man",
                "pparker@mit.com",
                6000,
                22);

        return array;
    }
}
