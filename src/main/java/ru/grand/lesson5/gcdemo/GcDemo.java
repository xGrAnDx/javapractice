package ru.grand.lesson5.gcdemo;

import ru.grand.lesson5.dumpdemo.MemHeavy;

public class GcDemo {
    public static void main(String[] args) {
        while(true)
        {
            var heavyMember = new MemHeavy();
            heavyMember = null;
        }
    }
}
