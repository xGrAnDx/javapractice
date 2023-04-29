package ru.grand.HW4;

public abstract class  Animal {
    private final long jumpLimit;
    private final long runLimit;

    private final long swimLimit;

    protected final String name;
    public Animal(String name, long jumpLimit, long runLimit, long swimLimit)
    {
        if (jumpLimit < 0)
            throw new IllegalArgumentException("jumpLimit");

        if (runLimit < 0)
            throw new IllegalArgumentException("runLimit");

        if (swimLimit < 0)
            throw new IllegalArgumentException("swimLimit");

        if (name == null)
            throw new IllegalArgumentException("name");

        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.name = name;
    }

    public void jump(int height) {
        if (height <=0 )
        {
            throw new IllegalArgumentException("height");
        }

        var res = height <= this.jumpLimit;
        System.out.println(String.format("%s jump: %s. Limit: [%s]", name, res, jumpLimit));
    }

    public void run(int length) {
        if (length <=0 )
        {
            throw new IllegalArgumentException("length");
        }
        var res = length <= this.runLimit;
        System.out.println(String.format("%s run: %s. Limit: [%s]", name, res, runLimit));
    }

    public void swim(int length) {
        if (length <=0 )
        {
            throw new IllegalArgumentException("height");
        }

        var res = length <= this.swimLimit;
        System.out.println(String.format("%s swim: %s. Limit: [%s]", name, res, swimLimit));
    }
}
