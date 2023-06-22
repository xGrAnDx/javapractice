package ru.grand.lesson8;

import java.util.HashSet;
import java.util.stream.Collectors;

public class VennSet extends HashSet<Integer> {
    public VennSet(VennSet integers) {
        super(integers);
    }

    public VennSet()
    {
        super();
    }

    public VennSet union(VennSet toUnite)
    {
        var result = new VennSet(this);
        result.addAll(toUnite);
        return result;
    }

    public VennSet intersect(VennSet toIntersect)
    {
        var result = new VennSet(this);
        result.retainAll(toIntersect);
        return result;
    }

    @Override
    public String toString()
    {
        return this.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
