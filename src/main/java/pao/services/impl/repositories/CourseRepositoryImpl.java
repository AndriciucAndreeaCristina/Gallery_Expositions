package pao.services.impl.repositories;

import pao.config.DatabaseConfiguration;
import pao.mappers.CourseMapper;
import pao.model.events.Course;
import pao.model.abstracts.Person;
import pao.services.interfaces.repositories.CourseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CourseRepositoryImpl implements CourseRepository {
    private static final CourseMapper courseMapper = CourseMapper.getInstance();
    @Override
    public Optional<Course> getCourseById(UUID id) {
        String selectSql = "SELECT * FROM course WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return courseMapper.mapToCourseClass(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Course> getCourseByTutor(Person tutor) {
        List<Course> courses = new ArrayList<>();
        String selectSql = "SELECT * FROM course WHERE tutor_id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, tutor.getId().toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                courses =courseMapper.mapToCourseClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public List<Course> getCourseByTitle(String title) {
        List<Course> courses = new ArrayList<>();
        String selectSql = "SELECT * FROM course WHERE title = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                courses = courseMapper.mapToCourseClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    @Override
    public List<Course> getAllCoursesFromList() {
        List<Course> courses = new ArrayList<>();
        String selectSql = "SELECT * FROM course";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                courses = courseMapper.mapToCourseClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }


    @Override
    public void addCourse(Course course) {
        String insertSql = "INSERT INTO course (id, title, description, tutor_id, formatType, price) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, course.getId().toString());
            preparedStatement.setString(2, course.getTitle());
            preparedStatement.setString(3, course.getDescription());
            preparedStatement.setString(4, course.getTutor().getId().toString());
            preparedStatement.setString(5, String.valueOf(course.getFormatType()));
            preparedStatement.setDouble(6, course.getPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCourseById(UUID id) {
        String deleteSql = "DELETE FROM course WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCourseByTitle(String title) {
        String deleteSql = "DELETE FROM course WHERE title = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, title);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCourseByTutor(Person tutor) {
        String deleteSql = "DELETE FROM course WHERE tutor_id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, tutor.getId().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyCourseById(UUID id, Course newEvent) {
        String updateSql = "UPDATE course SET title = ?, description = ?, tutor_id = ?, formatType = ?, price = ? WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, newEvent.getTitle());
            preparedStatement.setString(2, newEvent.getDescription());
            preparedStatement.setString(3, newEvent.getTutor().getId().toString());
            preparedStatement.setString(4, String.valueOf(newEvent.getFormatType()));
            preparedStatement.setDouble(5, newEvent.getPrice());
            preparedStatement.setString(6, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
