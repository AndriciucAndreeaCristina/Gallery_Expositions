package pao.animals;

public class Herbivore extends Animals {
    @Override
    public void eat() {
        System.out.println("Herbivore eating plants.");
    }

    @Override
    public double getFoodConsumption() {
        return 2.0;
    }
}
