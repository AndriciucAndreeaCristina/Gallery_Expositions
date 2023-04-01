package pao.model.events;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractPerson;

@SuperBuilder
@Getter
public class Person extends AbstractPerson {
    private String ocupation;
}
