package pao.services.impl;

import lombok.Getter;
import pao.model.exhibitions.Exhibition;
import pao.model.exhibitions.PermanentExhibition;
import pao.services.interfaces.exhibitions.ExhibitionInterface;

import java.util.*;

@Getter
public class PermanentExhibitionInterfaceImplementation implements ExhibitionInterface {
    private static SortedSet<PermanentExhibition> permanentExhibitionsList = new TreeSet<>();
    @Override
    public Optional<PermanentExhibition> getExhibitionById(UUID id) {
        return permanentExhibitionsList.stream()
                                       .filter(exhib ->exhib.getId().equals(id))
                                       .findAny();
    }

    @Override
    public SortedSet<PermanentExhibition> getExhibitionByTitle(String title) {
        return (SortedSet<PermanentExhibition>) permanentExhibitionsList.stream()
                .filter(exhib ->exhib.getTitle().equals(title));
    }

    @Override
    public SortedSet<PermanentExhibition> getAllExhibitionsFromList() {
        return permanentExhibitionsList;
    }

    @Override
    public void addAllExhibitions(List<? extends Exhibition> exhibitionsList) {
        permanentExhibitionsList.addAll((SortedSet<PermanentExhibition>) exhibitionsList);
    }

    @Override
    public void addExhibition(Exhibition exhibition) {
        permanentExhibitionsList.add((PermanentExhibition) exhibition);
    }

    @Override
    public void removeExhibitionById(UUID id) {
        permanentExhibitionsList = (SortedSet<PermanentExhibition>) permanentExhibitionsList.stream()
                .filter(exhib -> !id.equals(exhib.getId()));
    }

    @Override
    public void removeExhibitionByTitle(String title) {
        permanentExhibitionsList = (SortedSet<PermanentExhibition>)permanentExhibitionsList.stream()
                .filter(exhib -> !title.equals(exhib.getTitle()));
    }

    @Override
    public void modifyExhibitionById(UUID id, Exhibition newExhibition) {
        removeExhibitionById(id);
        addExhibition(newExhibition);
    }
}
