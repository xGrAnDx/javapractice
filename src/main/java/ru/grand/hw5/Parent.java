package ru.grand.hw5;

public class Parent {

    public static final String pConstField = parentConstInit();
    private static String parentConstInit() {
        System.out.println("Parent CONST initialization");
        return "CONST";
    }


    static {
        System.out.println("Parent static init #1");
    }

    {
        System.out.println("Parent init #1");
    }

    static {
        System.out.println("Parent static init #2");
    }

    {
        System.out.println("Parent init #2");
    }

    public Parent()
    {
        System.out.println("Parent .ctor");
    }
}
