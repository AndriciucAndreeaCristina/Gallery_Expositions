package pao.model.floorplan;

import lombok.Builder;
import lombok.Getter;
import pao.model.abstracts.AbstractEntity;
import pao.model.floorplan.enums.SectionsType;
import java.util.List;

@Builder
@Getter
public class Section extends AbstractEntity {
    private List<Room> rooms;
    private SectionsType type;

}
