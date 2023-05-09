package pao.lab9.animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalSighting {
    private String location;
    private LocalDate date;
    private String animalType;

    public AnimalSighting(String location, LocalDate date, String animalType) {
        this.location = location;
        this.date = date;
        this.animalType = animalType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public static List<AnimalSighting> filterByDate(List<AnimalSighting> sightings, LocalDate date) {
        List<AnimalSighting> filteredList = new ArrayList<>();
        for (AnimalSighting sighting : sightings) {
            if (sighting.getDate().equals(date)) {
                filteredList.add(sighting);
            }
        }
        return filteredList;
    }

    // Filter animal sightings by location
    public static List<AnimalSighting> filterByLocation(List<AnimalSighting> sightings, String location) {
        List<AnimalSighting> filteredList = new ArrayList<>();
        for (AnimalSighting sighting : sightings) {
            if (sighting.getLocation().equalsIgnoreCase(location)) {
                filteredList.add(sighting);
            }
        }
        return filteredList;
    }

    // Filter animal sightings by animal type
    public static List<AnimalSighting> filterByAnimalType(List<AnimalSighting> sightings, String animalType) {
        List<AnimalSighting> filteredList = new ArrayList<>();
        for (AnimalSighting sighting : sightings) {
            if (sighting.getAnimalType().equalsIgnoreCase(animalType)) {
                filteredList.add(sighting);
            }
        }
        return filteredList;
    }
}
