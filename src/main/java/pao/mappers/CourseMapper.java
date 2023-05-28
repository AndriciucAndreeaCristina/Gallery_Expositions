package pao.mappers;

import pao.generics.Mapper;
import pao.model.events.Course;
import pao.model.abstracts.Person;
import pao.model.events.enums.FormatType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class CourseMapper implements Mapper<Course> {
    private static final CourseMapper INSTANCE = new CourseMapper();

    private CourseMapper() {
    }

    public static CourseMapper getInstance() {
        return INSTANCE;
    }
    @Override
    public Optional<Course> mapToClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Course.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .description(resultSet.getString(3))
                            .tutor((Person) resultSet.getObject(4))
                            .formatType(FormatType.valueOf(resultSet.getString(5)))
                            .price(resultSet.getFloat(6))
                            .dates((List<LocalDate>) resultSet.getArray(7))
                            .weeklyThemes((Map<Integer, String>) resultSet.getArray(8))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Course> mapToClassList(ResultSet resultSet) throws SQLException {
        List<Course> exampleClassList = new ArrayList<>();
        while (resultSet.next()) {
            exampleClassList.add(
                    Course.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .description(resultSet.getString(3))
                            .tutor((Person) resultSet.getObject(4))
                            .formatType(FormatType.valueOf(resultSet.getString(5)))
                            .price(resultSet.getFloat(6))
                            .dates((List<LocalDate>) resultSet.getArray(7))
                            .weeklyThemes((Map<Integer, String>) resultSet.getArray(8))
                            .build()
            );
        }
        return exampleClassList;
    }
}
