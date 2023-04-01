package pao.model.artworks;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractEntity;
import pao.model.artworks.enums.Materials;

import java.util.List;

@Getter
@SuperBuilder
public class Artwork extends AbstractEntity {
    private Artist creator;
    private String title;
    private Integer yearOfCreation;
    private String description;
    private List<Materials> materialsList;
}
