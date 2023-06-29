package ru.grand.lesson8;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args){

        // Task 1: List performance comparison
        ListDemo.executeDemo();

        // Task 2: CustomTreeMap comparator demo
        customTreeDemo();

        //Task 3: HashSet operations demo
        hashSetDemo();

        //Task 4: Comparator demo
        comparatorDemo();

        //Task 5: standard functional interface demo:
        stdFunctionalDemo();

        //Task 6: Custom functional interface demo:
        customFunctionalDemo();

    }

    public static void customTreeDemo()
    {
        var customTree = new CustomTreeMap();

        customTree.put("three", "three");
        customTree.put("two", "two");
        customTree.put("one", "one");

        // original order three two one
        // expected : one two three
        for(Map.Entry<String, String> entry:customTree.entrySet())
        {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static void hashSetDemo()
    {
        var vennSet1 = new VennSet();
        vennSet1.add(1);
        vennSet1.add(2);
        vennSet1.add(3);
        vennSet1.add(4);

        var vennSet2 = new VennSet();
        vennSet2.add(3);
        vennSet2.add(4);
        vennSet2.add(5);
        vennSet2.add(6);

        System.out.format("Union result: %s\n", vennSet1.union(vennSet2));
        System.out.format("Intersect result: %s\n", vennSet1.intersect(vennSet2));

    }

    public static void comparatorDemo()
    {
        var persons = new PersonCollection();
        persons.add(new Person(19, "Simons"));
        persons.add(new Person(29, "Zelman"));
        persons.add(new Person(20, "Anderson"));

        //before
        System.out.println("Pre sort:");
        persons.print();

        // age sort
        System.out.println("Age sorted:");
        persons.sort(Comparator.comparingInt(person -> person.getAge()));
        persons.print();

        // name sort
        System.out.println("Name sorted:");
        persons.sort(Comparator.comparing(person -> person.getLastName()));
        persons.print();
    }

    public static void stdFunctionalDemo()
    {
        Supplier<Character> randomChar = () -> (char)(ThreadLocalRandom.current().nextInt(26) + 'a');
        System.out.format("Supplier demo: [%s]\n", randomChar.get());

        Consumer<String> firstLetter = (s) -> System.out.format("Consuming [%s] to print it.\n", s);
        firstLetter.accept("Consume me!");

        Predicate<Integer> isNegative = (i) -> i < 0;
        System.out.format("Predicate demo: %s is negative [%s]\n", -2, isNegative.test(-2));

        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.format("Operator showcase: %s to upper case [%s]\n", "bob", toUpperCase.apply("bob"));

        BooleanFunction and = (b1, b2) -> b1 && b2;
        BooleanFunction or = (b1, b2) -> {
                return b1 || b2;
        };

        BooleanFunction xor = new BooleanFunction() {
            @Override
            public boolean process(boolean b1, boolean b2) {
                return b1 ^ b2;
            }
        };

        var b1 = true;
        var b2 = false;
        System.out.println("My boolean functions");
        System.out.format("%s AND %s; %s\n", b1, b2, and.process(b1,b2));
        System.out.format("%s OR %s; %s\n", b1, b2, or.process(b1,b2));
        System.out.format("%s XOR %s; %s\n", b1, b2, xor.process(b1,b2));

    }

    public static void customFunctionalDemo()
    {
        ThreeFunction<Integer, Integer, Integer, Integer> sum = (x, y, z) -> x + y + z;
        ThreeFunction<String, String, String, String> concat = (x, y, z) -> x + y + z;

        System.out.format("Sum function result: [%s]\n", sum.execute(1,2,3));
        System.out.format("String concatenation: [%s]\n", concat.execute("Pls ", "concatenate ", "us!"));
    }

}
