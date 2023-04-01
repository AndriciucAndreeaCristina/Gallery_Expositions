package pao.model.events;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.events.enums.MaterialsCreativeWorkshop;

import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder
@Getter
public class CreativeWorkshop extends Event {
    private LocalDateTime date;
    private List<MaterialsCreativeWorkshop> materials;
}
