package pao.model.events;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuperBuilder
@Getter
public class Course extends Event {

    private List<LocalDateTime> dates;
    private Integer numberOfWeeks;
    private Map<UUID, String> weeklyThemes;


}
