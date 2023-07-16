package ru.grand.lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        mapDemo();
        reduceDemo();
    }

    public static void mapDemo() {
        Map<String, Map<String, String>> mp = new HashMap<>();

        mp.put("key1", new HashMap<>() {{
            put("Art1", "100");
            put("Max1", "200");
        }});


        mp.put("key2", new HashMap<>() {{
            put("Rita2", "300");
            put("Sasha2", "400");
            put("Igor2", "500");
        }});

        var result = mp.entrySet().stream().flatMap(
                (entry) -> entry.getValue().entrySet().stream().map(
                        (inner) -> new Object() {
                            String s1 = entry.getKey();
                            String s2 = inner.getKey();
                            String s3 = inner.getValue();
                        })).toList();
        result.stream().map((o) -> String.format("%s %s %s", o.s1, o.s2, o.s3)).forEach(System.out::println);
    }

    public static void reduceDemo()
    {
        List<String> sList = Arrays.asList("Astra", "Gorod Moskva", "River", "Ruslan", "Albatross" );

        var result = sList.stream().
                collect(Collectors.groupingBy(s->s.charAt(0), new CustomCollector()));

        for (var x:result.entrySet()){
            System.out.format("{ %s : %s }\n", x.getKey(), x.getValue());
        }
    }
}
