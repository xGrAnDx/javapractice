package ru.grand.HW4;

public class Dog extends Animal{

    private final long swimLimit;

    public Dog(String name, long jumpLimit, long runLimit, long swimLimit)
    {
        super(name, jumpLimit, runLimit);

        if (swimLimit <= 0)
            throw new IllegalArgumentException("swimLimit");

        this.swimLimit = swimLimit;
    }
    @Override
    public void Swim(int length) {
        if (length <=0 )
        {
            throw new IllegalArgumentException("height");
        }

        var res = length <= this.swimLimit;
        System.out.println(String.format("%s swim: %s. Limit: [%s]", name, res, swimLimit));
    }
}
