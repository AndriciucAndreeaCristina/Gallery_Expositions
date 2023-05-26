package pao.services.impl.repositories;

import pao.config.DatabaseConfiguration;
import pao.mappers.CreativeWorkshopMapper;
import pao.model.events.CreativeWorkshop;
import pao.services.interfaces.repositories.CreativeWorkshopRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CreativeWorkshopRepositoryImpl implements CreativeWorkshopRepository {
    private static final CreativeWorkshopMapper creativeWorkshopMapper = CreativeWorkshopMapper.getInstance();
    @Override
    public Optional<CreativeWorkshop> getCreativeWorkshopById(UUID id) {
        String selectSql = "SELECT * FROM creative_workshop WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return creativeWorkshopMapper.mapToCreativeWorkshopClass(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<CreativeWorkshop> getEventByTitle(String title) {
        List<CreativeWorkshop> creativeWorkshops = new ArrayList<>();
        String selectSql = "SELECT * FROM creative_workshop WHERE title = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                creativeWorkshops = creativeWorkshopMapper.mapToCreativeWorkshopClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creativeWorkshops;
    }


    @Override
    public void addCreativeWorkshop(CreativeWorkshop event) {
        String insertSql = "INSERT INTO creative_workshop (id, title, date, description) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, event.getId().toString());
            preparedStatement.setString(2, event.getTitle());
            preparedStatement.setString(3, event.getDate().toString());
            preparedStatement.setString(4, event.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void removeCreativeWorkshopById(UUID id) {
        String deleteSql = "DELETE FROM creative_workshop WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCreativeWorkshopByTitle(String title) {
        String deleteSql = "DELETE FROM creative_workshop WHERE title = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, title);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyCreativeWorkshopById(UUID id, CreativeWorkshop newEvent) {
        String updateSql = "UPDATE creative_workshop SET title = ?, date = ?, description = ? WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, newEvent.getTitle());
            preparedStatement.setDate(2, Date.valueOf(String.valueOf(newEvent.getDate())));
            preparedStatement.setString(3, newEvent.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
