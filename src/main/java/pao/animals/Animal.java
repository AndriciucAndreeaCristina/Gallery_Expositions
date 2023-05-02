package pao.animals;

import pao.animals.exceptions.InvalidAnimal;
import pao.animals.exceptions.InvalidDate;
import pao.animals.exceptions.InvalidSpeed;

import java.time.LocalDate;

public sealed class Animal permits Mammal, Bird, Reptile {
    private String name;
    private int speed;
    private LocalDate dateOfBirth;

    public Animal(String name, int speed, LocalDate dateOfBirth) throws InvalidAnimal, InvalidSpeed, InvalidDate {
        if (name == null || name.isEmpty()) {
            throw new InvalidAnimal("Invalid animal name");
        }

        if (speed <= 0) {
            throw new InvalidSpeed("Invalid speed value");
        }

        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) {
            throw new InvalidDate("Invalid date of birth");
        }

        this.name = name;
        this.speed = speed;
        this.dateOfBirth = dateOfBirth;
    }

    public Animal(String name) {
        this.name = name;
    }

    public void speed() {
        System.out.println("This animal has a specific speed.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
