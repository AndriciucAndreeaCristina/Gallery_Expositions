package pao.model.events;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractPerson;

@SuperBuilder
@Getter
@EqualsAndHashCode
public class Person extends AbstractPerson {
    private String ocupation;
}
