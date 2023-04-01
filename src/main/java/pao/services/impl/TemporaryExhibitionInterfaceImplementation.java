package pao.services.impl;

import lombok.Getter;
import pao.model.exhibitions.Exhibition;
import pao.model.exhibitions.TemporaryExhibition;
import pao.services.interfaces.exhibitions.ExhibitionInterface;

import java.util.*;

@Getter
public class TemporaryExhibitionInterfaceImplementation implements ExhibitionInterface {
    private static SortedSet<TemporaryExhibition> temporaryExhibitionsList = new TreeSet<>();
    @Override
    public Optional<TemporaryExhibition> getExhibitionById(UUID id) {
        return temporaryExhibitionsList.stream()
                .filter(exhib ->exhib.getId().equals(id))
                .findAny();
    }

    @Override
    public SortedSet<TemporaryExhibition> getExhibitionByTitle(String title) {
        return (SortedSet<TemporaryExhibition>) temporaryExhibitionsList.stream()
                .filter(exhib ->exhib.getTitle().equals(title));
    }

    @Override
    public SortedSet<TemporaryExhibition> getAllExhibitionsFromList() {
        return temporaryExhibitionsList;
    }

    @Override
    public void addAllExhibitions(List<? extends Exhibition> exhibitionsList) {
        temporaryExhibitionsList.addAll((SortedSet<TemporaryExhibition>) exhibitionsList);
    }

    @Override
    public void addExhibition(Exhibition exhibition) {
        temporaryExhibitionsList.add((TemporaryExhibition) exhibition);
    }

    @Override
    public void removeExhibitionById(UUID id) {
        temporaryExhibitionsList = (SortedSet<TemporaryExhibition>) temporaryExhibitionsList.stream()
                .filter(exhib -> !id.equals(exhib.getId()));
    }

    @Override
    public void removeExhibitionByTitle(String title) {
        temporaryExhibitionsList = (SortedSet<TemporaryExhibition>)temporaryExhibitionsList.stream()
                .filter(exhib -> !title.equals(exhib.getTitle()));
    }

    @Override
    public void modifyExhibitionById(UUID id, Exhibition newExhibition) {
        removeExhibitionById(id);
        addExhibition(newExhibition);
    }
}
