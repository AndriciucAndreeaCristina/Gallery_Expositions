package pao.mappers;

import pao.generics.Mapper;
import pao.model.artworks.Artwork;
import pao.model.exhibitions.TemporaryExhibition;
import pao.model.floorplan.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TemporaryExhibitionMapper implements Mapper<TemporaryExhibition> {
    private static final TemporaryExhibitionMapper INSTANCE = new TemporaryExhibitionMapper();

    public static TemporaryExhibitionMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<TemporaryExhibition> mapToClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    TemporaryExhibition.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .description(resultSet.getString(3))
                            .artworksList((List<Artwork>) resultSet.getArray(4))
                            .startDate(resultSet.getDate(5).toLocalDate())
                            .endDate(resultSet.getDate(6).toLocalDate())
                            .room((Room) resultSet.getObject(7))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<TemporaryExhibition> mapToClassList(ResultSet resultSet) throws SQLException {
        List<TemporaryExhibition> exampleClassList = new ArrayList<>();
        while (resultSet.next()) {
            exampleClassList.add(
                    TemporaryExhibition.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .description(resultSet.getString(3))
                            .artworksList((List<Artwork>) resultSet.getArray(4))
                            .startDate(resultSet.getDate(5).toLocalDate())
                            .endDate(resultSet.getDate(6).toLocalDate())
                            .room((Room) resultSet.getObject(7))
                            .build()
            );
        }

        return exampleClassList;
    }
}
