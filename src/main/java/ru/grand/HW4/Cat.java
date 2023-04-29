package ru.grand.HW4;

public class Cat extends Animal {
    public Cat()
    {
        super("Default", 200, 200, 0);
    }
    public Cat(String name, long jumpLimit, long runLimit)
    {
       super(name, jumpLimit, runLimit, 0);
    }

    @Override
    public void swim(int length) {
        System.out.println(name + " swim: false");
    }
}
