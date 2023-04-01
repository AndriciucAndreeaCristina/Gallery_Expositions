package pao.model.exhibitions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.floorplan.Section;

@SuperBuilder
@Getter
public class PermanentExhibition extends Exhibition implements Comparable<PermanentExhibition> {
    private Section section;

    @Override
    public int compareTo(PermanentExhibition o) {
        return o.getTitle().compareTo(this.getTitle());
    }
}
