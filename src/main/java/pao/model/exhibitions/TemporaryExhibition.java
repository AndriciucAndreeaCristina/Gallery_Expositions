package pao.model.exhibitions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.artworks.Artwork;
import pao.model.floorplan.Room;
import pao.services.impl.ExhibitionInterfaceImplementation;

import java.time.LocalDate;
import java.util.List;

@SuperBuilder
@Getter
public class TemporaryExhibition extends ExhibitionInterfaceImplementation {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Artwork> artworksList;
    private Room room;
}
