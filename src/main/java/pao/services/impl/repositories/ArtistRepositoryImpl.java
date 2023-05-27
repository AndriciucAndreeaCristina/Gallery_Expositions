package pao.services.impl.repositories;

import pao.application.csv.CsvWriter;
import pao.config.DatabaseConfiguration;
import pao.mappers.ArtistMapper;
import pao.model.abstracts.Artist;
import pao.services.interfaces.repositories.ArtistRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ArtistRepositoryImpl implements ArtistRepository {
    private static final ArtistMapper artistMapper = ArtistMapper.getInstance();
    private static CsvWriter csvWriter = CsvWriter.getInstance();
    @Override
    public List<Artist> getArtistsByMovement(String movement) {
        return null;
    }

    @Override
    public Optional<Artist> getArtistByFirstName(String firstName) throws Exception {

        String selectSql = "SELECT * FROM abstractperson, artist WHERE first_name=? AND abstractperson.id = artist.id";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, firstName.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return artistMapper.mapToArtistClass(resultSet);
        } catch (SQLException e) {
            List<String[]> lines = new ArrayList<>();
            lines.add(new String[]{e.getMessage(), e.getLocalizedMessage()});
            csvWriter.executeLineByLine(lines);
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Object> getArtistByLastName(String lastName) throws Exception {

        String selectSql = "SELECT * FROM artist WHERE last_name=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, lastName.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(artistMapper.mapToArtistClassList(resultSet));
        } catch (SQLException e) {
            List<String[]> lines = new ArrayList<>();
            lines.add(new String[]{e.getMessage(), e.getLocalizedMessage()});
            csvWriter.executeLineByLine(lines);
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Artist> getArtistById(UUID id) throws Exception {

        String selectSql = "SELECT * FROM artist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return artistMapper.mapToArtistClass(resultSet);
        } catch (SQLException e) {
            List<String[]> lines = new ArrayList<>();
            lines.add(new String[]{e.getMessage(), e.getLocalizedMessage()});
            csvWriter.executeLineByLine(lines);
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void addArtist(Artist artist) throws Exception {
        String sql1 = "INSERT INTO abstractentity (id, creationdate) " +
                "VALUES (?, ?)";
        String sql2 = "INSERT INTO abstractperson (id, first_name, last_name, birth_date, description) VALUES (?, ?, ?, ?, ?)";

        String selectSql = "INSERT INTO artist  (id, movement) VALUES (?, ?)";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
             PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
             PreparedStatement preparedStatement3 = connection.prepareStatement(selectSql)) {

            preparedStatement1.setObject(1, artist.getId());
            preparedStatement1.setObject(2, artist.getCreationDate());
            preparedStatement1.executeUpdate();

            preparedStatement2.setObject(1, artist.getId());
            preparedStatement2.setObject(2, artist.getFirstName());
            preparedStatement2.setObject(3, artist.getLastName());
            preparedStatement2.setObject(4, artist.getBirthDate());
            preparedStatement2.setObject(5, artist.getDescription());
            preparedStatement2.executeUpdate();

            preparedStatement3.setString(1, artist.getId().toString());
            preparedStatement3.setString(2, artist.getMovement().toString());
            preparedStatement3.executeUpdate();

            List<String[]> lines = new ArrayList<>();
            lines.add(new String[]{"Artist", artist.getFirstName(), artist.getLastName()});
            csvWriter.executeLineByLine(lines);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void removeArtistById(UUID id) throws Exception {
        String updateNameSql = "DELETE FROM artist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    public void removeArtistByFirstNameLastName(String firstName, String lastName) throws Exception {
        String updateNameSql = "DELETE FROM artist WHERE first_name=? AND last_name=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, firstName.toString());
            preparedStatement.setString(2, lastName.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void modifyArtistById(UUID id, Artist newArtist) {
        String updateNameSql = "UPDATE example_table SET name=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newArtist.getFirstName());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
