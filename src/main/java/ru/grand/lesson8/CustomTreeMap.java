package ru.grand.lesson8;

import java.util.Comparator;
import java.util.TreeMap;

public class CustomTreeMap extends TreeMap<String, String> {
    public CustomTreeMap() {
        super(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
    }
}
