package pao.lab9.animals;

import pao.lab9.animals.exceptions.InvalidAnimal;
import pao.lab9.animals.exceptions.InvalidDate;
import pao.lab9.animals.exceptions.InvalidSpeed;

import java.time.LocalDate;

public final class Mammal extends Animal {
    public Mammal(String name, int speed, LocalDate dateOfBirth) throws InvalidAnimal, InvalidSpeed, InvalidDate {
        super(name, speed, dateOfBirth);
    }

    public Mammal() throws InvalidAnimal, InvalidDate, InvalidSpeed {
        super("", 0, LocalDate.ofEpochDay(01/01/1970));
    }

    public Mammal(String name) {
        super(name);
    }

    @Override
    public void speed() {
        System.out.println("Mammals generally have moderate speeds.");
    }
}
