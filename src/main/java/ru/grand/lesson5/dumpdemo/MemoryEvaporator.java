package ru.grand.lesson5.dumpdemo;

import java.util.ArrayList;

//Execution arguments: -Xmx256m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=E:/soft/dump
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
