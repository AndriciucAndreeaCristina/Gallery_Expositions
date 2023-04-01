package pao.model.artworks;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractPerson;


@SuperBuilder
@Getter
public class Artist extends AbstractPerson {
    private String movement;

}
