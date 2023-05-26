package pao.services.impl.floorplan;

import pao.model.floorplan.Section;
import pao.model.floorplan.enums.SectionsType;
import pao.services.interfaces.floorplan.SectionInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SectionInterfaceImplementation implements SectionInterface {
    List<Section> sectionsList = new ArrayList<>();
    @Override
    public Optional<Section> getSectionById(UUID id) {
        return sectionsList.stream()
                .filter(section -> section.getId().equals(id))
                .findAny();
    }

    @Override
    public List<Section> getSectionsByType(SectionsType type) {
        return sectionsList.stream()
                .filter(section -> section.getType().equals(type))
                .toList();
    }

    @Override
    public List<Section> getAllRooms() {
        return sectionsList;
    }

    @Override
    public void addAllSections(List<Section> sections) {
        sectionsList.addAll(sections);
    }

    @Override
    public void addSection(Section section) {
        sectionsList.add(section);
    }

    @Override
    public void removeSectionById(UUID id) {
        sectionsList = sectionsList.stream()
                .filter(section -> !id.equals(section.getId()))
                .toList();
    }

    @Override
    public void modifySectionById(UUID id, Section newSection) {
        removeSectionById(id);
        addSection(newSection);
    }
}
