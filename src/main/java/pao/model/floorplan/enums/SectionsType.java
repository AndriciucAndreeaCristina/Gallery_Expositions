package pao.model.floorplan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SectionsType {
    COMPUTER_ART("computer_art"),
    GRAFFITI_ART("graffiti_art"),
    HYPERREALISM("hyperrealism"),
    INSTALLATION_ART("installation_art"),
    MINIMALISM("minimalism"),
    PERFORMANCE_ART("performance_art"),
    POP_ART("pop_art"),
    POSTMODERNISM("postmodernism"),
    TRANSAVANTGARDE("transavantgarde"),
    VIDEO_INSTALLATION("video_installation"),
    NONE("none");

    private final String typeString;
    public static SectionsType getEnumByFieldString(String field) {
        return Arrays.stream(SectionsType.values())
                .filter(enumElement -> enumElement.getTypeString().equals(field))
                .findAny()
                .orElse(NONE);
    }
}
