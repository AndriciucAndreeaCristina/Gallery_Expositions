package pao.model.artworks;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractEntity;
import pao.model.abstracts.Artist;
import pao.model.artworks.enums.Materials;

@Getter
@SuperBuilder
@EqualsAndHashCode
public class Artwork extends AbstractEntity implements Comparable<Artwork> {
    private Artist creator;
    private String title;
    private Integer yearOfCreation;
    private String description;
    private Materials material;
    @Override
    public int compareTo(Artwork o) {
        int result = o.creator.getFirstName().compareTo(this.creator.getFirstName());
        if (result == 0)
        {
            result = o.creator.getLastName().compareTo(this.creator.getLastName());
        }
        if (result == 0)
        {
            result = o.yearOfCreation.compareTo(this.yearOfCreation);
        }
        if (result == 0)
        {
            result = o.title.compareTo(this.title);
        }
        return result;
    }

    @Override
    public String toString() {
        String str = "\t Title: " + this.title + "\n"
                    + "\t Creator: " + this.creator.getFirstName() + " " + this.creator.getLastName() + "\n"
                    + "\t Description: " + this.description + "\n"
                    + "\t Year of Creation: " + this.yearOfCreation + "\n"
                    + "\t Material: " + this.getMaterial().toString() + "\n\n";
        return str;
    }
}
