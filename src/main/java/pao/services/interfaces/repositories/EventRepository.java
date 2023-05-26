package pao.services.interfaces.repositories;

import pao.model.events.Event;
import pao.model.events.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventRepository {
    Optional<Event> getEventById(UUID id);
    List<Event> getEventByTutor(Person tutor);
    List<Event> getEventByTitle(String title);
    List<Event> getAllEventsFromList();
    void addAllEvents(List<Event> eventsList);
    void addEvent(Event event);
    void removeEventById(UUID id);
    void removeEventByTitle(String title);
    void removeEventByTutor(Person tutor);
    void modifyEventById(UUID id, Event newEvent);
}
