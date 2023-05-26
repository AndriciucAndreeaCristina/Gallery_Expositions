package pao.services.interfaces.exhibitions;

import pao.model.exhibitions.Exhibition;

import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.UUID;

public interface ExhibitionInterface {
    Optional<? extends Exhibition> getExhibitionById(UUID id);
    SortedSet<? extends Exhibition> getExhibitionByTitle(String title);
    SortedSet<? extends Exhibition> getAllExhibitionsFromList();
    void addAllExhibitions(List<? extends Exhibition> exhibitionsList);
    void addExhibition(Exhibition exhibition);
    void removeExhibitionById(UUID id);
    void removeExhibitionByTitle(String title);
    void modifyExhibitionById(UUID id, Exhibition newExhibition);
}
