package pao.animals;

abstract class AnimalHandler {
    public abstract void handleAnimal(Animal animal);
}

class MammalHandler extends AnimalHandler {
    @Override
    public void handleAnimal(Animal animal) {
        if (animal instanceof Mammal) {
            Mammal mammal = (Mammal) animal;
            // Handle mammal
            System.out.println("Handling mammal: " + mammal.getName());
        } else {
            throw new IllegalArgumentException("Invalid animal type for MammalHandler");
        }
    }
}

class BirdHandler extends AnimalHandler {
    @Override
    public void handleAnimal(Animal animal) {
        if (animal instanceof Bird) {
            Bird bird = (Bird) animal;
            // Handle bird
            System.out.println("Handling bird: " + bird.getName());
        } else {
            throw new IllegalArgumentException("Invalid animal type for BirdHandler");
        }
    }
}

class ReptileHandler extends AnimalHandler {
    @Override
    public void handleAnimal(Animal animal) {
        if (animal instanceof Reptile) {
            Reptile reptile = (Reptile) animal;
            // Handle reptile
            System.out.println("Handling reptile: " + reptile.getName());
        } else {
            throw new IllegalArgumentException("Invalid animal type for ReptileHandler");
        }
    }
}
