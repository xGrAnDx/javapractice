package ru.grand.HW4;

import ru.grand.HW3.Person;

public class HW4 {
    public static void main(String[] args) {
        var speedy = Spawner.SpawnDog("Speedy");
        var bitey = Spawner.SpawnDog("Bitey");
        var mrPuffy = Spawner.SpawnCat("Mr Puffy");
        var mrFluffy = Spawner.SpawnCat("Mr Fluffy");

        speedy.Run(420);
        bitey.Run(560);

        speedy.Swim(8);
        bitey.Swim(11);

        speedy.Jump(46);
        speedy.Jump(70);

        mrPuffy.Run(240);
        mrPuffy.Jump(210);
        mrPuffy.Swim(10);

        mrFluffy.Run(190);
        mrFluffy.Jump(70);
    }
}
