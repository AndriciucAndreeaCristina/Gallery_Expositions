package pao.services.interfaces.repositories;

import pao.model.events.CreativeWorkshop;
import pao.model.events.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CreativeWorkshopRepository {
    Optional<CreativeWorkshop> getCreativeWorkshopById(UUID id);
    List<CreativeWorkshop> getCreativeWorkshopByTutor(Person tutor);
    List<CreativeWorkshop> getEventByTitle(String title);
    List<CreativeWorkshop> getAllCreativeWorkshopFromList();
    void addAllCreativeWorkshops(List<CreativeWorkshop> eventsList);
    void addCreativeWorkshop(CreativeWorkshop event);
    void removeCreativeWorkshopById(UUID id);
    void removeCreativeWorkshopByTitle(String title);
    void removeCreativeWorkshopByTutor(Person tutor);
    void modifyCreativeWorkshopById(UUID id, CreativeWorkshop newEvent);
}
