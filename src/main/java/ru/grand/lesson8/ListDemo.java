package ru.grand.lesson8;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class ListDemo {

    private static final String baseStr = "baseStr";
    private static void calcExecutionTime(Consumer<AbstractList<String>> consumer, AbstractList<String> list)
    {
        var start = System.nanoTime();
        consumer.accept(list);
        var end = System.nanoTime();

        System.out.format("Execution time: %s ns\n", (end-start));
    }

    public static void executeDemo()
    {
        var arrayList = new ArrayList<String>();
        var linkedList = new LinkedList<String>();
        initList(arrayList);
        initList(linkedList);


        System.out.println("Insert to end:");
        System.out.print("Array list:");
        calcExecutionTime(ListDemo::insertEnd, arrayList);
        System.out.print("Linked list:");
        calcExecutionTime(ListDemo::insertEnd, linkedList);

        System.out.println("Insert to top:");
        System.out.print("Array list:");
        calcExecutionTime(ListDemo::insertTop, arrayList);
        System.out.print("Linked list:");
        calcExecutionTime(ListDemo::insertTop, linkedList);

        System.out.println("Insert to middle:");
        System.out.print("Array list:");
        calcExecutionTime(ListDemo::insertMiddle, arrayList);
        System.out.print("Linked list:");
        calcExecutionTime(ListDemo::insertMiddle, linkedList);

        System.out.println("Random search:");
        System.out.print("Array list:");
        calcExecutionTime(ListDemo::searchArray, arrayList);
        System.out.print("Linked list:");
        calcExecutionTime(ListDemo::searchArray, linkedList);

    }

    private static void initList(AbstractList<String> toInit)
    {
        var r = ThreadLocalRandom.current();

        for(int i=0;i<10000;i++)
        {
            toInit.add(baseStr + (char)(r.nextInt(26) + 'a'));
        }
    }

    private static void insertEnd(AbstractList<String> list)
    {
        var r = ThreadLocalRandom.current();
        for(int i=0;i<1000;i++) {
            list.add(baseStr + (char) (r.nextInt(26) + 'a'));
        }
    }

    private static void insertTop(AbstractList<String> list)
    {
        var r = ThreadLocalRandom.current();
        for(int i=0;i<1000;i++) {
            list.add(0, baseStr + (char) (r.nextInt(26) + 'a'));
        }
    }

    private static void insertMiddle(AbstractList<String> list)
    {
        var r = ThreadLocalRandom.current();
        for(int i=0;i<1000;i++) {
            list.add(list.size() / 2, baseStr + (char) (r.nextInt(26) + 'a'));
        }
    }

    private static void searchArray(AbstractList<String> list)
    {
        var r = ThreadLocalRandom.current();
        for(int i=0;i<1000;i++) {
            list.get(r.nextInt(list.size()));
        }
    }
}
