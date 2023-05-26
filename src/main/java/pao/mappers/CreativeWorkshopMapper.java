package pao.mappers;

import pao.model.events.CreativeWorkshop;
import pao.model.events.Person;
import pao.model.events.enums.FormatType;
import pao.model.events.enums.MaterialsCreativeWorkshop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CreativeWorkshopMapper {
    private static final CreativeWorkshopMapper INSTANCE = new CreativeWorkshopMapper();

    private CreativeWorkshopMapper() {
    }

    public static CreativeWorkshopMapper getInstance() {
        return INSTANCE;
    }

    public Optional<CreativeWorkshop> mapToCreativeWorkshopClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    CreativeWorkshop.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .description(resultSet.getString(3))
                            .tutor((Person) resultSet.getObject(4))
                            .formatType(FormatType.valueOf(resultSet.getString(5)))
                            .price(resultSet.getFloat(6))
                            .date(LocalDateTime.from(resultSet.getDate(7).toLocalDate()))
                            .materials((List<MaterialsCreativeWorkshop>) resultSet.getArray(8))
                            .build()
            );

        } else {
            return Optional.empty();
        }
    }

    public List<CreativeWorkshop> mapToCreativeWorkshopClassList(ResultSet resultSet) throws SQLException {
        List<CreativeWorkshop> exampleClassList = new ArrayList<>();
        while (resultSet.next()) {
            exampleClassList.add(
                    CreativeWorkshop.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .description(resultSet.getString(3))
                            .tutor((Person) resultSet.getObject(4))
                            .formatType(FormatType.valueOf(resultSet.getString(5)))
                            .price(resultSet.getFloat(6))
                            .date(LocalDateTime.from(resultSet.getDate(7).toLocalDate()))
                            .materials((List<MaterialsCreativeWorkshop>) resultSet.getArray(8))
                            .build()
            );
        }

        return exampleClassList;
    }
}
