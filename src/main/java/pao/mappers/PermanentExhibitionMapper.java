package pao.mappers;

import pao.generics.Mapper;
import pao.model.artworks.Artwork;
import pao.model.exhibitions.PermanentExhibition;
import pao.model.floorplan.Section;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PermanentExhibitionMapper implements Mapper<PermanentExhibition> {
    private static final PermanentExhibitionMapper INSTANCE = new PermanentExhibitionMapper();

    public static PermanentExhibitionMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<PermanentExhibition> mapToClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    PermanentExhibition.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .description(resultSet.getString(3))
                            .artworksList((List<Artwork>) resultSet.getArray(4))
                            .section((Section) resultSet.getObject(5))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<PermanentExhibition> mapToClassList(ResultSet resultSet) throws SQLException {
        List<PermanentExhibition> exampleClassList = new ArrayList<>();
        while (resultSet.next()) {
            exampleClassList.add(
                    PermanentExhibition.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .description(resultSet.getString(3))
                            .artworksList((List<Artwork>) resultSet.getArray(4))
                            .section((Section) resultSet.getObject(5))
                            .build()
            );
        }

        return exampleClassList;
    }

}
