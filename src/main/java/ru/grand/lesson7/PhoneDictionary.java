package ru.grand.lesson7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private Collection<PhoneOrder> phoneList = new ArrayList<>();

    public void add(PhoneOrder order)
    {
        this.phoneList.add(order);
    }

    public void getEntries(String lastName)
    {
        var result = this.phoneList.stream().filter((po) -> po.lastName.equalsIgnoreCase(lastName)).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
