package pao.model.artworks;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractPerson;
import pao.model.floorplan.enums.SectionsType;


@SuperBuilder
@Getter
public class Artist extends AbstractPerson {
    private SectionsType movement;

    @Override
    public String toString() {
        String str = "\t First Name: " + this.getFirstName() +
                "\n\t Last Name: " + this.getLastName() +
                "\n\t Birth date: " + this.getBirthDate() +
                "\n\t Movement: " + this.getMovement() +
                "\n\t Description: " + this.getDescription() + "\n\n";
        return str;
    }

}
