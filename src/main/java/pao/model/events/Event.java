package pao.model.events;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractEntity;
import pao.model.events.enums.FormatType;

@Getter
@SuperBuilder
@EqualsAndHashCode
@AllArgsConstructor
public class Event extends AbstractEntity {
    private String title;
    private String description;
    private Person tutor;
    private FormatType formatType;
    private Float price;
}
