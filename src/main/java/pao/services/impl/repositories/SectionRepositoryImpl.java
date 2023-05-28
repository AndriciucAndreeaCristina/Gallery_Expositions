package pao.services.impl.repositories;

import pao.config.DatabaseConfiguration;
import pao.mappers.SectionMapper;
import pao.model.floorplan.Section;
import pao.model.floorplan.enums.SectionsType;
import pao.services.interfaces.repositories.SectionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SectionRepositoryImpl implements SectionRepository {
    private static final SectionMapper sectionMapper = SectionMapper.getInstance();
    @Override
    public Optional<Section> getSectionById(UUID id) {
        String selectSql = "SELECT * FROM section WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return sectionMapper.mapToClass(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Section> getSectionsByType(SectionsType type) {
        List<Section> sections = new ArrayList<>();
        String selectSql = "SELECT * FROM section WHERE type = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, type.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sections = sectionMapper.mapToClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sections;
    }

    @Override
    public List<Section> getAllSections() {
        List<Section> sections = new ArrayList<>();
        String selectSql = "SELECT * FROM section";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSql)) {
            if (resultSet.next()) {
                sections = sectionMapper.mapToClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sections;
    }

    @Override
    public void addSection(Section section) {
        String insertSql = "INSERT INTO section (id, type) VALUES (?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, section.getId().toString());
            preparedStatement.setString(2, section.getType().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeSectionById(UUID id) {
        String deleteSql = "DELETE FROM section WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifySectionById(UUID id, Section newSection) {
        String updateSql = "UPDATE section SET  type = ? WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, newSection.getType().toString());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
