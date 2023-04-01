package pao.model.floorplan;

import lombok.Builder;
import lombok.Getter;
import pao.model.floorplan.enums.SectionsType;
import java.util.List;

@Builder
@Getter
public class Section {
    private List<Room> rooms;
    private SectionsType type;

}
