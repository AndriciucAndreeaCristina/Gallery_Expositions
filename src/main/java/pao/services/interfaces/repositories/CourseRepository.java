package pao.services.interfaces.repositories;

import pao.model.events.Course;
import pao.model.events.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository {
    Optional<Course> getCourseById(UUID id);
    List<Course> getCourseByTutor(Person tutor);
    List<Course> getCourseByTitle(String title);
    List<Course> getAllCoursesFromList();
    void addCourse(Course event);
    void removeCourseById(UUID id);
    void removeCourseByTitle(String title);
    void removeCourseByTutor(Person tutor);
    void modifyCourseById(UUID id, Course newEvent);
}
