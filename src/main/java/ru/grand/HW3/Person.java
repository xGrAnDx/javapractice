package ru.grand.HW3;

public class Person {
    private String name;
    private String position;
    private String email;
    private int salary;
    private int age;

    public Person(
        String name,
        String position,
        String email,
        int salary,
        int age
    )
    {
        if (name == null)
            throw new NullPointerException("name");
        if (position == null)
            throw new NullPointerException("position");
        if (email == null)
            throw new NullPointerException("email");
        if (salary <= 0)
            throw new IllegalArgumentException("salary");
        if (age < 18)
            throw new IllegalArgumentException("name");

        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public String toString()
    {
        return String.format(
                "Person: \n Name: %s \n Position: %s \n Email: %s \n Salary: %s Unit \n Age: %sy",
                this.name,
                this.position,
                this.email,
                this.salary,
                this.age);
    }
}
