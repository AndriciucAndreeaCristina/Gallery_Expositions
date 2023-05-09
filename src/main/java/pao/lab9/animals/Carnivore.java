package pao.lab9.animals;

public class Carnivore extends Animals {
    @Override
    public void eat() {
        System.out.println("Carnivore eating meat.");
    }

    @Override
    public double getFoodConsumption() {
        return 1.5;
    }
}
