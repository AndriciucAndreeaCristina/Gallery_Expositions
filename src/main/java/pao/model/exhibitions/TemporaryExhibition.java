package pao.model.exhibitions;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import pao.model.floorplan.Room;

import java.time.LocalDate;

@SuperBuilder
@Getter
@ToString
public class TemporaryExhibition extends Exhibition implements Comparable<TemporaryExhibition> {
    private LocalDate startDate;
    private LocalDate endDate;
    private Room room;

    @Override
    public int compareTo(TemporaryExhibition o) {
        int result = o.startDate.compareTo(this.startDate);
        if (result == 0)
        {
            result = o.endDate.compareTo(this.endDate);
        }
        return result;
    }

}
