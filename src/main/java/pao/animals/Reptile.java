package pao.animals;

import pao.animals.exceptions.InvalidAnimal;
import pao.animals.exceptions.InvalidDate;
import pao.animals.exceptions.InvalidSpeed;

import java.time.LocalDate;

public final class Reptile extends Animal {
//    public Reptile(String name, int speed, LocalDate dateOfBirth) throws InvalidAnimal, InvalidSpeed, InvalidDate {
//        super(name, speed, dateOfBirth);
//    }
    public Reptile() throws InvalidAnimal, InvalidDate, InvalidSpeed {
        super("", 0, LocalDate.ofEpochDay(01/01/1970));
    }

    public Reptile(String name) {
        super(name);
    }

    @Override
    public void speed() {
        System.out.println("Reptiles have diverse speeds based on their species.");
    }
}
