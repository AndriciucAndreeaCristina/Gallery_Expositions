package pao.model.events;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractEntity;
import pao.model.events.enums.FormatType;
import pao.model.events.enums.MaterialsCreativeWorkshop;

import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder
@Getter
public class CreativeWorkshop extends AbstractEntity {
    private String title;
    private String description;
    private Person tutor;
    private LocalDateTime date;
    private List<MaterialsCreativeWorkshop> materials;
    private FormatType formatType;
    private Float price;
}
