package ru.grand.HW4;

public class Spawner {
    private static final long catMinHeightCm = 180;
    private static final long catMaxHeightCm = 240;

    private static final long dogMinHeightCm = 45;
    private static final long dogMaxHeightCm = 60;

    private static final long catMinRunLength = 150;
    private static final long catMaxRunLength = 250;

    private static final long dogMinRunLength = 400;
    private static final long dogMaxRunLength = 600;

    private static final long dogMinSwimLength = 8;
    private static final long dogMaxSwimLength = 12;

    public static Cat spawnCat(String name)
    {
        var catJump = getRandom(catMinHeightCm, catMaxHeightCm);
        var catRun = getRandom(catMinRunLength, catMaxRunLength);

        return new Cat(name, catJump, catRun);
    }

    public static Dog spawnDog(String name)
    {
        var dogJump = getRandom(dogMinHeightCm, dogMaxHeightCm);
        var dogRun = getRandom(dogMinRunLength, dogMaxRunLength);
        var dogSwim = getRandom(dogMinSwimLength,dogMaxSwimLength);

        return new Dog(name, dogJump, dogRun, dogSwim);
    }

    public static Dog spawnDefaultDog()
    {
        return new Dog();
    }

    public static Cat spawnDefaultCat()
    {
        return new Cat();
    }

    private static long getRandom(long min, long max)
    {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
