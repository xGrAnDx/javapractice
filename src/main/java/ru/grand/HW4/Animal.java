package ru.grand.HW4;

public class Animal {
    private final long jumpLimit;
    private final long runLimit;

    protected final String name;
    public Animal(String name, long jumpLimit, long runLimit)
    {
        if (jumpLimit < 0)
            throw new IllegalArgumentException("jumpLimit");

        if (runLimit < 0)
            throw new IllegalArgumentException("runLimit");

        if (name == null)
            throw new IllegalArgumentException("name");

        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
        this.name = name;
    }

    public void Jump(int height) {
        if (height <=0 )
        {
            throw new IllegalArgumentException("height");
        }

        var res = height <= this.jumpLimit;
        System.out.println(String.format("%s jump: %s. Limit: [%s]", name, res, jumpLimit));
    }

    public void Run(int length) {
        if (length <=0 )
        {
            throw new IllegalArgumentException("length");
        }
        var res = length <= this.runLimit;
        System.out.println(String.format("%s run: %s. Limit: [%s]", name, res, runLimit));
    }

    public void Swim(int length)
    {

    }
}
