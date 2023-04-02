package pao.model.events.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum FormatType {
    ONLINE("online"),
    IN_PERSON("in_person"),
    NONE("none");

    private final String typeString;
    public static FormatType getEnumByFieldString(String field) {
        return Arrays.stream(FormatType.values())
                .filter(enumElement -> enumElement.getTypeString().equals(field))
                .findAny()
                .orElse(NONE);
    }
}
