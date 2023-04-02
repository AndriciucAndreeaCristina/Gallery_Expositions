package pao.model.floorplan;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractEntity;
import pao.model.floorplan.enums.SectionsType;

import java.util.List;

@SuperBuilder
@Getter
public class Section extends AbstractEntity {
    private List<Room> rooms;
    private SectionsType type;

}
