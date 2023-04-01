package pao.services.impl;

import pao.model.events.CreativeWorkshop;
import pao.model.events.Event;
import pao.model.events.Person;
import pao.services.interfaces.events.EventInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EventWorkshopInterfaceImplementation implements EventInterface {
    private static List<CreativeWorkshop> workshopsList = new ArrayList<>();

    @Override
    public Optional<CreativeWorkshop> getEventById(UUID id) {
        return workshopsList.stream()
                .filter(ws -> ws.getId().equals(id))
                .findAny();
    }

    @Override
    public List<CreativeWorkshop> getEventByTutor(Person tutor) {
        return workshopsList.stream()
                .filter(ws -> ws.getTutor().equals(tutor))
                .toList();
    }

    @Override
    public List<CreativeWorkshop> getEventByTitle(String title) {
        return workshopsList.stream()
                .filter(ws -> ws.getTitle().equals(title))
                .toList();
    }

    @Override
    public List<CreativeWorkshop> getAllEventsFromList() {
        return workshopsList;
    }

    @Override
    public void addAllEvents(List<? extends Event> eventsList) {
        workshopsList.addAll((List<CreativeWorkshop>) eventsList);
    }

    @Override
    public void addEvent(Event event) {
        workshopsList.add((CreativeWorkshop) event);
    }

    @Override
    public void removeEventById(UUID id) {
        workshopsList = workshopsList.stream()
                .filter(element -> !id.equals(element.getId()))
                .toList();
    }

    @Override
    public void removeEventByTitle(String title) {
        workshopsList = workshopsList.stream()
                .filter(element -> !title.equals(element.getTitle()))
                .toList();
    }

    @Override
    public void removeEventByTutor(Person tutor) {
        workshopsList = workshopsList.stream()
                .filter(element -> !tutor.equals(element.getTutor()))
                .toList();
    }

    @Override
    public void modifyEventById(UUID id, Event newEvent) {
        removeEventById(id);
        addEvent(newEvent);
    }
}
