package pao.animals;

public class Omnivore extends Animals {
    @Override
    public void eat() {
        System.out.println("Omnivore eating both meat and plants.");
    }

    @Override
    public double getFoodConsumption() {
        return 1.8;
    }
}
