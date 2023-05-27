package pao.services.interfaces.events;

import pao.model.events.Event;
import pao.model.abstracts.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventInterface {
    Optional<? extends Event> getEventById(UUID id);
    List<? extends Event> getEventByTutor(Person tutor);
    List<? extends Event> getEventByTitle(String title);
    List<? extends Event> getAllEventsFromList();
    void addAllEvents(List<? extends Event> eventsList);
    void addEvent(Event event);
    void removeEventById(UUID id);
    void removeEventByTitle(String title);
    void removeEventByTutor(Person tutor);
    void modifyEventById(UUID id, Event newEvent);
}
