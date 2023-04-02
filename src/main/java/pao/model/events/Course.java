package pao.model.events;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuperBuilder
@Getter
@Setter
public class Course extends Event {

    private List<LocalDate> dates;
    private Map<Integer, String> weeklyThemes;

    @Override
    public String toString() {
        String str = "Title: " + this.getTitle() + "\n"
                + "\t Description: " + this.getDescription() + "\n"
                + "\t Tutor: " + this.getTutor().getFirstName() + " " + this.getTutor().getLastName() + "\n"
                + "\t Price: " + this.getPrice().toString() + "dollars\n";
        Iterator<Map.Entry<Integer, String>> itr = this.weeklyThemes.entrySet().iterator();

        while(itr.hasNext())
        {
            Map.Entry<Integer, String> entry = itr.next();
            str += "\t\t Week " + entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return str;
    }
}
