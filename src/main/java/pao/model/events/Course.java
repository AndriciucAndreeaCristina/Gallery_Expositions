package pao.model.events;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@SuperBuilder
@Getter
public class Course extends Event {

    private List<LocalDate> dates;
    private Map<Integer, String> weeklyThemes;


}
