package pao.model.floorplan;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Room {
    private Integer floor;
    private Integer number;
}
