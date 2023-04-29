package ru.grand.HW4;

public class Dog extends Animal{

    public Dog()
    {
        super("Default", 50, 500, 10);
    }

    public Dog(String name, long jumpLimit, long runLimit, long swimLimit)
    {
        super(name, jumpLimit, runLimit, swimLimit);
    }
}
