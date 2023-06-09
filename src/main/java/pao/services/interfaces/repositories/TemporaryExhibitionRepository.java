package pao.services.interfaces.repositories;

import pao.model.exhibitions.TemporaryExhibition;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TemporaryExhibitionRepository {
    Optional<TemporaryExhibition> getTExhibitionById(UUID id);
    List<TemporaryExhibition> getTExhibitionByTitle(String title);
    List<TemporaryExhibition> getAllTExhibitionsFromList();
    void addTExhibition(TemporaryExhibition exhibition);
    void removeTExhibitionById(UUID id);
    void modifyTExhibitionById(UUID id, TemporaryExhibition newExhibition);
}
