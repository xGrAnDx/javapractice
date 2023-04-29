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

    public static Cat SpawnCat(String name)
    {
        var catJump = GetRandom(catMinHeightCm, catMaxHeightCm);
        var catRun = GetRandom(catMinRunLength, catMaxRunLength);

        return new Cat(name, catJump, catRun);
    }

    public static Dog SpawnDog(String name)
    {
        var dogJump = GetRandom(dogMinHeightCm, dogMaxHeightCm);
        var dogRun = GetRandom(dogMinRunLength, dogMaxRunLength);
        var dogSwim = GetRandom(dogMinSwimLength,dogMaxSwimLength);

        return new Dog(name, dogJump, dogRun, dogSwim);
    }

    private static long GetRandom(long min, long max)
    {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
