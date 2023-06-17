package ru.grand.lesson5.gcdemo;

import ru.grand.lesson5.dumpdemo.MemHeavy;

// Execution arguments: -Xlog:gc*=debug:file=E:\Trash\gc.log -Xmx256m
public class GcDemo {
    public static void main(String[] args) {
        while(true)
        {
            var heavyMember = new MemHeavy();
            heavyMember = null;
        }
    }
}
