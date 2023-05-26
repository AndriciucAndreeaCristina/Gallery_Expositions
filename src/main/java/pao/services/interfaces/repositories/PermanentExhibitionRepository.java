package pao.services.interfaces.repositories;

import pao.model.exhibitions.PermanentExhibition;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PermanentExhibitionRepository {
    Optional<PermanentExhibition> getPExhibitionById(UUID id);
    List<PermanentExhibition> getPExhibitionByTitle(String title);
    List<PermanentExhibition> getAllPExhibitionsFromList();
    void addAllPExhibitions(List<PermanentExhibition> exhibitionsList);
    void addPExhibition(PermanentExhibition exhibition);
    void removePExhibitionById(UUID id);
    void removePExhibitionByTitle(String title);
    void modifyPExhibitionById(UUID id, PermanentExhibition newExhibition);
}
