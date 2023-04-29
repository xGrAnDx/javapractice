package ru.grand.HW4;

import java.lang.constant.Constable;

public class Cat extends Animal {
    public Cat(String name, long jumpLimit, long runLimit)
    {
       super(name, jumpLimit, runLimit);
    }

    @Override
    public void Swim(int length) {
        System.out.println(name + " swim: false");
    }
}
