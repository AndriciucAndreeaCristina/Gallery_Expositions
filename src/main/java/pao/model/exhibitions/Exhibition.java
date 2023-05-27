package pao.model.exhibitions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractEntity;
import pao.model.artworks.Artwork;

import java.util.List;

@SuperBuilder
@Getter
@EqualsAndHashCode
public sealed class Exhibition extends AbstractEntity permits PermanentExhibition, TemporaryExhibition {
    private String title;
    private String description;
    private List<Artwork> artworksList;

}
