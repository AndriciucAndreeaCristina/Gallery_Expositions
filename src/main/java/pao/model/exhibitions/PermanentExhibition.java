package pao.model.exhibitions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.artworks.Artwork;
import pao.model.floorplan.Section;
import pao.services.impl.ExhibitionInterfaceImplementation;

import java.util.List;

@SuperBuilder
@Getter
public class PermanentExhibition extends ExhibitionInterfaceImplementation {
    private String title;
    private String description;
    private Section section;
    private List<Artwork> artworksList;
}
