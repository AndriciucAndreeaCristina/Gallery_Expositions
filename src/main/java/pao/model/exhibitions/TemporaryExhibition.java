package pao.model.exhibitions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.floorplan.Room;

import java.time.LocalDate;

@SuperBuilder
@Getter
public final class TemporaryExhibition extends Exhibition implements Comparable<TemporaryExhibition> {
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

    @Override
    public String toString() {
        String str = "Title: " + this.getTitle() + "\n"
                  + "Floor: " + this.getRoom().getFloor() + "\n"
                  + "Room: " + this.getRoom().getNumber() + "\n";
        return str;
    }

}
