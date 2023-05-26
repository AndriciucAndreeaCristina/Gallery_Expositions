package pao.services.interfaces.repositories;

import pao.model.floorplan.Section;
import pao.model.floorplan.enums.SectionsType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SectionRepository {
    Optional<Section> getSectionById(UUID id);

    List<Section> getSectionsByType(SectionsType type);

    List<Section> getAllRooms();

    void addAllSections(List<Section> sections);

    void addSection(Section section);

    void removeSectionById(UUID id);

    void modifySectionById(UUID id, Section newSection);
}
