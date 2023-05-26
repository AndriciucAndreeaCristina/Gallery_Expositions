package pao.model.events;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pao.model.events.enums.MaterialsCreativeWorkshop;

import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder
@Getter
@Setter
public class CreativeWorkshop extends Event {
    private LocalDateTime date;
    private List<MaterialsCreativeWorkshop> materials;

    @Override
    public String toString() {
        String str = "Title: " + this.getTitle() + "\n"
                    + "\t Description: " + this.getDescription() + "\n"
                    + "\t Tutor: " + this.getTutor().getFirstName() + " " + this.getTutor().getLastName() + "\n"
                    + "\t Price: " + this.getPrice().toString() + "dollars\n"
                    + "\t Date: " + this.date.toString() + "\n";
        return str;
    }
}
