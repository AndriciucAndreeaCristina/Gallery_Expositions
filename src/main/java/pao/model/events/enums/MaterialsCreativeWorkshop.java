package pao.model.events.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum MaterialsCreativeWorkshop {
    A3_OFF_WHITE_PAPER("a3_off_white_paper"),
    A3_WHITE_PAPER("a3_white_paper"),
    BRUSH("brush"),
    COMPRESSED_CHARCOAL("compressed_charcoal"),
    DIPPING_PEN("dipping_pen"),
    INDIAN_INK("indina_ink"),
    RUBBER("rubber"),
    SMALL_SHEET("small_sheet"),
    SOFT_CLOTH("soft_cloth"),
    WILLOW_CHARCOAL("willow_charcol"),
    NONE("none");
    private final String typeString;
    public static MaterialsCreativeWorkshop getEnumByFieldString(String field) {
        return Arrays.stream(MaterialsCreativeWorkshop.values())
                .filter(enumElement -> enumElement.getTypeString().equals(field))
                .findAny()
                .orElse(NONE);
    }
}
