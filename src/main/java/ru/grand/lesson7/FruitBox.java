package ru.grand.lesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class FruitBox<T extends Fruit>{

    private double fruitWeight;
    private ArrayList<T> innerList = new ArrayList<>();

    public FruitBox(double fruitWeight)
    {
        this.fruitWeight = fruitWeight;
    }

    public FruitBox add(T fruit)
    {
        innerList.add(fruit);
        return this;
    }

    public FruitBox clear()
    {
        innerList.clear();
        return this;
    }

    public double getWeight()
    {
        return fruitWeight * innerList.size();
    }

    public boolean compare(FruitBox box)
    {
        return this.getWeight() == box.getWeight();
    }

    public void merge(FruitBox<T> box)
    {
        var enumeration = box.getEnumeration();
        while(enumeration.hasMoreElements())
        {
            var f = enumeration.nextElement();
            this.innerList.add(f);
        }

        box.clear();
    }

    public Enumeration<T> getEnumeration()
    {
        return Collections.enumeration(this.innerList);
    }
}
