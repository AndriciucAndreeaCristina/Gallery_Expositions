package pao.animals;

import pao.animals.exceptions.InvalidAnimal;
import pao.animals.exceptions.InvalidDate;
import pao.animals.exceptions.InvalidSpeed;

import java.time.LocalDate;

public final class Bird extends Animal {
    public Bird(String name, int speed, LocalDate dateOfBirth) throws InvalidAnimal, InvalidSpeed, InvalidDate {
        super(name, speed, dateOfBirth);
    }

    public Bird() throws InvalidAnimal, InvalidDate, InvalidSpeed {
        super("", 0, LocalDate.ofEpochDay(01/01/1970));
    }

    public Bird(String name) {
        super(name);
    }

    @Override
    public void speed() {
        System.out.println("Birds can fly, so they have varying speeds.");
    }
}