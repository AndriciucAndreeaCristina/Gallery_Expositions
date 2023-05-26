package pao.services.impl.repositories;

import pao.config.DatabaseConfiguration;
import pao.mappers.ArtworkMapper;
import pao.model.artworks.Artist;
import pao.model.artworks.Artwork;
import pao.services.interfaces.repositories.ArtWorkRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ArtWorkRepositoryImpl implements ArtWorkRepository {
    private static final ArtworkMapper artworkMapper = ArtworkMapper.getInstance();
    @Override
    public Optional<Artwork> getArtworkById(UUID id) {
        String SELECT_BY_ID_SQL = "SELECT * FROM artwork WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return artworkMapper.mapToArtworkClass(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Artwork> getArtworkByCreator(Artist creator) {
        List<Artwork> result = new ArrayList<>();
        String SELECT_BY_CREATOR_SQL = "SELECT * FROM artwork WHERE creator_id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CREATOR_SQL)) {
            preparedStatement.setString(1, creator.getId().toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               return artworkMapper.mapToArtistClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Optional<Artwork> getArtworkByTitle(String title) {
        String SELECT_BY_TITLE_SQL = "SELECT * FROM artwork WHERE title=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_TITLE_SQL)) {
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return artworkMapper.mapToArtworkClass(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Artwork> getAllArtworksFromSet() {
        List<Artwork> result = new ArrayList<>();
        String SELECT_ALL_SQL = "SELECT * FROM artwork";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
            while (resultSet.next()) {
                return artworkMapper.mapToArtistClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void addArtwork(Artwork artwork) {
        String insertSql = "INSERT INTO artwork (id, creator_id, title, yearOfCreation, description, material) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, artwork.getId().toString());
            preparedStatement.setString(2, artwork.getCreator().getId().toString());
            preparedStatement.setString(3, artwork.getTitle());
            preparedStatement.setInt(4, artwork.getYearOfCreation());
            preparedStatement.setString(5, artwork.getDescription());
            preparedStatement.setString(6, String.valueOf(artwork.getMaterial()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeArtworkById(UUID id) {
        String deleteSql = "DELETE FROM artwork WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeArtworkByTitle(String title) {
        String deleteSql = "DELETE FROM artwork WHERE title = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, title);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeArtworkByCreator(Artist creator) {
        String deleteSql = "DELETE FROM artwork WHERE creator_id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, creator.getId().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyArtworkById(UUID id, Artwork newArtwork) {
        String updateSql = "UPDATE artwork SET creator_id = ?, title = ?, yearOfCreation = ?, description = ?, material = ? WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, newArtwork.getCreator().getId().toString());
            preparedStatement.setString(2, newArtwork.getTitle());
            preparedStatement.setInt(3, newArtwork.getYearOfCreation());
            preparedStatement.setString(4, newArtwork.getDescription());
            preparedStatement.setString(5, String.valueOf(newArtwork.getMaterial()));
            preparedStatement.setString(6, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
