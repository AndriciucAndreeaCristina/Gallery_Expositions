package pao.mappers;

import pao.generics.Mapper;
import pao.model.floorplan.Room;
import pao.model.floorplan.Section;
import pao.model.floorplan.enums.SectionsType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SectionMapper implements Mapper<Section> {
    private static final SectionMapper INSTANCE = new SectionMapper();

    public static SectionMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<Section> mapToClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Section.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .rooms((List<Room>) resultSet.getArray(2))
                            .type(SectionsType.valueOf(resultSet.getString(3)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Section> mapToClassList(ResultSet resultSet) throws SQLException {
        List<Section> exampleClassList = new ArrayList<>();
        while (resultSet.next()) {
            exampleClassList.add(
                    Section.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .rooms((List<Room>) resultSet.getArray(2))
                            .type(SectionsType.valueOf(resultSet.getString(3)))
                            .build()
            );
        }

        return exampleClassList;
    }
}
