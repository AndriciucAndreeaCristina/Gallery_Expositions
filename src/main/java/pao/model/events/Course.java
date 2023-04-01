package pao.model.events;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractEntity;
import pao.model.events.enums.FormatType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuperBuilder
@Getter
public class Course extends AbstractEntity {
    private String title;
    private String description;
    private Person tutor;
    private List<LocalDateTime> dates;
    private Integer numberOfWeeks;
    private Map<UUID, String> weeklyThemes;
    private FormatType formatType;
    private Float price;

}
