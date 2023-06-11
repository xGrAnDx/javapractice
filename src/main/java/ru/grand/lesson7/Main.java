package ru.grand.lesson7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        swapDemo();
        arrayListDemo();
        fruitDemo();
        wordCountDemo();
        phoneDictionaryDemo();
    }

    public static void arrayListDemo()
    {
        var input = new String[] { "1", "2", "3", "4"};
        System.out.println("Original:");
        printArray(input);

        var list = toArrayList(input);
        printList(list);
    }

    public static void swapDemo()
    {
        Integer[] integerDemo = new Integer[] { 1, 2, 3, 4};
        String[] stringDemo = new String[] { "1", "2", "3", "4"};

        swapReferences(integerDemo,1,2);
        swapReferences(stringDemo,1,2);

        printArray(integerDemo);
        printArray(stringDemo);
    }

    private static <T> void printArray(T[] array)
    {
        for (T e:array)
        {
            System.out.print(e + " ");
        }
        System.out.print("\n");
    }

    private static <T> void printList(ArrayList<T> array)
    {
        for (T e:array)
        {
            System.out.print(e + " ");
        }
        System.out.print("\n");
    }

    public static void fruitDemo()
    {
        var appleBox = new FruitBox<Apple>(1.0f);
        appleBox.add(new Apple()).add(new Apple()).add(new Apple());

        var orangeBox = new FruitBox<Orange>(1.5f);
        orangeBox.add(new Orange()).add(new Orange());

        System.out.format(
                "Boxes are equal? W1:[%s], W2:[%s]. [%s]\n",
                appleBox.getWeight(),
                orangeBox.getWeight(),
                appleBox.compare(orangeBox));

        orangeBox.add(new Orange());

        System.out.format(
                "Boxes are equal? W1:[%s], W2:[%s]. [%s]\n",
                appleBox.getWeight(),
                orangeBox.getWeight(),
                appleBox.compare(orangeBox));

        var secondAppleBox = new FruitBox<Apple>(1.0f);
        secondAppleBox.add(new Apple());

        System.out.format(
                "Weight before merge. W1:[%s] W2:[%s]\n",
                appleBox.getWeight(),
                secondAppleBox.getWeight());

        appleBox.merge(secondAppleBox);

        System.out.format(
                "Weight after merge. W1:[%s] W2:[%s]\n",
                appleBox.getWeight(),
                secondAppleBox.getWeight());
    }

    public static <T> void swapReferences(T[] array, int index1, int index2)
    {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static <T> ArrayList<T> toArrayList(T[] array)
    {
        var list = new ArrayList<T>();
        for(T element:array)
        {
            list.add(element);
        }

        return list;
    }

    public static void wordCountDemo()
    {
        var input = new String[] {"one", "two", "three","four","five", "six", "seven", "two","three","six", "one","four", "four", "seven", "two", "six"};

        var dictionary = new HashMap<String, Integer>();

        for(var s:input)
        {
            if (dictionary.containsKey(s))
            {
                dictionary.put(s, dictionary.get(s) + 1);
            }
            else {
                dictionary.put(s, 1);
            }
        }

        for(Map.Entry<String,Integer> e:dictionary.entrySet())
        {
            System.out.format("Word [%s] found [%s] times.\n", e.getKey(), e.getValue());
        }
    }

    public static void phoneDictionaryDemo()
    {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new PhoneOrder("Смирнов","+79000000001"));
        phoneDictionary.add(new PhoneOrder("Смирнов","+79000000002"));
        phoneDictionary.add(new PhoneOrder("Иванов","+79000000003"));
        phoneDictionary.add(new PhoneOrder("Петров","+79000000004"));

        phoneDictionary.getEntries("Смирнов");
        phoneDictionary.getEntries("Иванов");
        phoneDictionary.getEntries("Петров");

    }
}
