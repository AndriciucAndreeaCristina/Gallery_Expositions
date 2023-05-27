package pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract sealed class AbstractPerson extends AbstractEntity permits Artist, Person {
   private String firstName;
   private String lastName;
   private LocalDate birthDate;
   private String description;

}
