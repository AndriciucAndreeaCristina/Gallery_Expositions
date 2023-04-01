package pao.model.floorplan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SectionsType {
    COMPUTER_ART("computer_art", 0),
    GRAFFITI_ART("graffiti_art", 1),
    HYPERREALISM("hyperrealism", 2),
    INSTALLATION_ART("installation_art", 3),
    MINIMALISM("minimalism", 4),
    PERFORMANCE_ART("performance_art", 5),
    POP_ART("pop_art", 6),
    POSTMODERNISM("postmodernism", 7),
    TRANSAVANTGARDE("transavantgarde", 8),
    VIDEO_INSTALLATION("video_installation", 9),
    NONE("none", 10);

    private final String typeString;
    private final Integer id;
    public static SectionsType getEnumByFieldString(String field) {
        return Arrays.stream(SectionsType.values())
                .filter(enumElement -> enumElement.getTypeString().equals(field))
                .findAny()
                .orElse(NONE);
    }
}
