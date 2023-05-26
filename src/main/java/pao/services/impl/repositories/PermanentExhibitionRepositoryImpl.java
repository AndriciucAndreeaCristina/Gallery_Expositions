package pao.services.impl.repositories;

import pao.config.DatabaseConfiguration;
import pao.mappers.PermanentExhibitionMapper;
import pao.model.exhibitions.PermanentExhibition;
import pao.services.interfaces.repositories.PermanentExhibitionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PermanentExhibitionRepositoryImpl implements PermanentExhibitionRepository {
    private static final PermanentExhibitionMapper permanentExhibitionMapper = PermanentExhibitionMapper.getInstance();
    @Override
    public Optional<PermanentExhibition> getPExhibitionById(UUID id) {
        String selectSql = "SELECT * FROM permanent_exhibition WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return permanentExhibitionMapper.mapToPermanentExhibitionClass(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<PermanentExhibition> getPExhibitionByTitle(String title) {
        List<PermanentExhibition> exhibitions = new ArrayList<>();
        String selectSql = "SELECT * FROM permanent_exhibition WHERE title = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                exhibitions = permanentExhibitionMapper.mapToPermanentExhibitionClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exhibitions;
    }

    @Override
    public List<PermanentExhibition> getAllPExhibitionsFromList() {
        List<PermanentExhibition> exhibitions = new ArrayList<>();
        String selectSql = "SELECT * FROM permanent_exhibition";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSql)) {

            while (resultSet.next()) {
                exhibitions = permanentExhibitionMapper.mapToPermanentExhibitionClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exhibitions;
    }

    @Override
    public void addPExhibition(PermanentExhibition exhibition) {
        String insertSql = "INSERT INTO permanent_exhibition (id, title, description) VALUES (?, ?, ?)";

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
    public void removePExhibitionById(UUID id) {
        String deleteSql = "DELETE FROM permanent_exhibition WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyPExhibitionById(UUID id, PermanentExhibition newExhibition) {
        String updateSql = "UPDATE permanent_exhibition SET title = ?, description = ? WHERE id = ?";

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
