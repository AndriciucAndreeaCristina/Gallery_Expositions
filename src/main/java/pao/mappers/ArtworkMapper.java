package pao.mappers;

import pao.model.artworks.Artwork;
import pao.model.artworks.enums.Materials;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ArtworkMapper {
    private static final ArtworkMapper INSTANCE = new ArtworkMapper();

    private ArtworkMapper() {
    }

    public static ArtworkMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Artwork> mapToArtworkClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Artwork.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .creationDate(resultSet.getDate(2).toLocalDate())
                            .title(resultSet.getString(3))
                            .yearOfCreation(resultSet.getInt(4))
                            .description(resultSet.getString(5))
                            .material(Materials.valueOf(resultSet.getString(6)))
                            .build()
            );

        } else {
            return Optional.empty();
        }
    }

    public List<Artwork> mapToArtistClassList(ResultSet resultSet) throws SQLException {
        List<Artwork> exampleClassList = new ArrayList<>();
        while (resultSet.next()) {
            exampleClassList.add(
                    Artwork.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .creationDate(resultSet.getDate(2).toLocalDate())
                            .title(resultSet.getString(3))
                            .yearOfCreation(resultSet.getInt(4))
                            .description(resultSet.getString(5))
                            .material(Materials.valueOf(resultSet.getString(6)))
                            .build()
            );
        }

        return exampleClassList;
    }
}
