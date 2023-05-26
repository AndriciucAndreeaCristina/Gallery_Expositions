package pao.services.interfaces.repositories;

import pao.model.events.CreativeWorkshop;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CreativeWorkshopRepository {
    Optional<CreativeWorkshop> getCreativeWorkshopById(UUID id);
    List<CreativeWorkshop> getEventByTitle(String title);
    void addCreativeWorkshop(CreativeWorkshop event);
    void removeCreativeWorkshopById(UUID id);
    void removeCreativeWorkshopByTitle(String title);
    void modifyCreativeWorkshopById(UUID id, CreativeWorkshop newEvent);
}
