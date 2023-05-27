package pao.model.abstracts;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.AbstractPerson;

@SuperBuilder
@Getter
@EqualsAndHashCode
public non-sealed class Person extends AbstractPerson {
    private String ocupation;
}
