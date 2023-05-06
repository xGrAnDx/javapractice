package ru.grand.hw5;

public class Child extends Parent {

    public static final String constField = childConstInit();
    private static String childConstInit() {
        System.out.println("Child CONST initialization");
        return "CONST";
    }

    static {
        System.out.println("Child static init #1");
    }

    {
        System.out.println("Child init #1");
    }

    static {
        System.out.println("Child static init #2");
    }

    {
        System.out.println("Child init #2");
    }

    public Child()
    {
        System.out.println("Child .ctor");
    }
}
