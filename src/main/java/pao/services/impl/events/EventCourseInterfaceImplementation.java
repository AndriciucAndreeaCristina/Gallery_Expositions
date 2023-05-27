package pao.services.impl.events;

import lombok.Getter;
import pao.model.events.Course;
import pao.model.events.Event;
import pao.model.abstracts.Person;
import pao.services.interfaces.events.EventInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
public class EventCourseInterfaceImplementation implements EventInterface {
    private static List<Course> coursesList = new ArrayList<>();

    @Override
    public Optional<Course> getEventById(UUID id) {
        return coursesList.stream()
                .filter(course -> course.getId().equals(id))
                .findAny();
    }

    @Override
    public List<Course> getEventByTutor(Person tutor) {
        return coursesList.stream()
                .filter(course -> course.getTutor().equals(tutor))
                .toList();
    }

    @Override
    public List<Course> getEventByTitle(String title) {
        return coursesList.stream()
                .filter(course -> course.getTitle().equals(title))
                .toList();
    }

    @Override
    public List<Course> getAllEventsFromList() {
        return coursesList;
    }

    @Override
    public void addAllEvents(List<? extends Event> eventsList) {
        coursesList.addAll((List<Course>) eventsList);
    }

    @Override
    public void addEvent(Event event) {
        coursesList.add((Course) event);
    }

    @Override
    public void removeEventById(UUID id) {
        coursesList = coursesList.stream()
                .filter(element -> !id.equals(element.getId()))
                .toList();
    }

    @Override
    public void removeEventByTitle(String title) {
        coursesList = coursesList.stream()
                .filter(element -> !title.equals(element.getTitle()))
                .toList();
    }

    @Override
    public void removeEventByTutor(Person tutor) {
        coursesList = coursesList.stream()
                .filter(element -> !tutor.equals(element.getTutor()))
                .toList();
    }

    @Override
    public void modifyEventById(UUID id, Event newEvent) {
        removeEventById(id);
        addEvent(newEvent);
    }
}
