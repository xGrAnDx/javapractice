package ru.grand.HW4;

public class HW4 {
    public static void main(String[] args) {
        var speedy = Spawner.SpawnDog("Speedy");
        var bitey = Spawner.SpawnDog("Bitey");
        var mrPuffy = Spawner.SpawnCat("Mr Puffy");
        var mrFluffy = Spawner.SpawnCat("Mr Fluffy");
        var dDog = Spawner.SpawnDefaultDog();
        var dCat = Spawner.SpawnDefaultCat();


        speedy.run(420);
        bitey.run(560);

        speedy.swim(8);
        bitey.swim(11);

        speedy.jump(46);
        speedy.jump(70);

        mrPuffy.run(240);
        mrPuffy.jump(210);
        mrPuffy.swim(10);

        mrFluffy.run(190);
        mrFluffy.jump(70);

        dDog.jump(60);
        dDog.swim(11);
        dDog.run(510);
    }
}
