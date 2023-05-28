package pao.services.impl.repositories;

import pao.config.DatabaseConfiguration;
import pao.mappers.TemporaryExhibitionMapper;
import pao.model.exhibitions.TemporaryExhibition;
import pao.services.interfaces.repositories.TemporaryExhibitionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TemporaryExhibitionRepositoryImpl implements TemporaryExhibitionRepository {
    private static final TemporaryExhibitionMapper temporaryExhibitionMapper = TemporaryExhibitionMapper.getInstance();
    @Override
    public Optional<TemporaryExhibition> getTExhibitionById(UUID id) {
        String selectSql = "SELECT * FROM temporary_exhibition WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return temporaryExhibitionMapper.mapToClass(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TemporaryExhibition> getTExhibitionByTitle(String title) {
        List<TemporaryExhibition> exhibitions = new ArrayList<>();
        String selectSql = "SELECT * FROM temporary_exhibition WHERE title = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                exhibitions = temporaryExhibitionMapper.mapToClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exhibitions;
    }

    @Override
    public List<TemporaryExhibition> getAllTExhibitionsFromList() {
        List<TemporaryExhibition> exhibitions = new ArrayList<>();
        String selectSql = "SELECT * FROM temporary_exhibition";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSql)) {

            while (resultSet.next()) {
                exhibitions = temporaryExhibitionMapper.mapToClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exhibitions;
    }

    @Override
    public void addTExhibition(TemporaryExhibition exhibition) {
        String insertSql = "INSERT INTO temporary_exhibition (id, title, description) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, exhibition.getId().toString());
            preparedStatement.setString(2, exhibition.getTitle());
            preparedStatement.setString(3, exhibition.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTExhibitionById(UUID id) {
        String deleteSql = "DELETE FROM temporary_exhibition WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyTExhibitionById(UUID id, TemporaryExhibition newExhibition) {
        String updateSql = "UPDATE temporary_exhibition SET title = ?, description = ? WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, newExhibition.getTitle());
            preparedStatement.setString(2, newExhibition.getDescription());
            preparedStatement.setString(3, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
