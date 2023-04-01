package pao.model.floorplan;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractEntity;

@SuperBuilder
@Getter
public class Room extends AbstractEntity {
    private Integer floor;
    private Integer number;
}
