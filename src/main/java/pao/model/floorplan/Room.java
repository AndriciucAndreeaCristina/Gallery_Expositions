package pao.model.floorplan;

import lombok.Builder;
import lombok.Getter;
import pao.model.abstracts.AbstractEntity;

@Builder
@Getter
public class Room extends AbstractEntity {
    private Integer floor;
    private Integer number;
}
