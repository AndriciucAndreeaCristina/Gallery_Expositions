package pao.mappers;

import pao.model.artworks.Artist;
import pao.model.floorplan.enums.SectionsType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ArtistMapper {
    private static final ArtistMapper INSTANCE = new ArtistMapper();

    public static ArtistMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Artist> mapToArtistClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Artist.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .firstName(resultSet.getString(3))
                            .lastName(resultSet.getString(4))
                            .birthDate(resultSet.getDate(5).toLocalDate())
                            .description(resultSet.getString(6))
                            .movement(SectionsType.valueOf(resultSet.getString(7)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Artist> mapToArtistClassList(ResultSet resultSet) throws SQLException {
        List<Artist> exampleClassList = new ArrayList<>();
        while (resultSet.next()) {
            exampleClassList.add(
                    Artist.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .creationDate(resultSet.getDate(2).toLocalDate())
                            .firstName(resultSet.getString(3))
                            .lastName(resultSet.getString(4))
                            .birthDate(resultSet.getDate(5).toLocalDate())
                            .description(resultSet.getString(6))
                            .movement(SectionsType.valueOf(resultSet.getString(7)))
                            .build()
            );
        }

        return exampleClassList;
    }
}
