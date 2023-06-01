package ru.grand.lesson5.dumpdemo;

import java.util.ArrayList;

public class MemoryEvaporator {
    private static ArrayList<MemHeavy> heavyList = new ArrayList<>();
    public static void main(String[] args) {
        while(true)
        {
            var heavyMember = new MemHeavy();
            heavyList.add(heavyMember);
        }
    }
}
