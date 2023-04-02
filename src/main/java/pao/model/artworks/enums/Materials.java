package pao.model.artworks.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Materials {
    ACRYLIC_ON_CANVAS ("acrylic_on_canvas", 0),
    ACRYLIC_ON_PAPER ("acrylic_on_paper", 1),
    ACRYLIC_ON_WOOD ("acrylic_on_wood", 2),
    ACRYLIC_ON_GLASS("acrylic_on_glass", 3),
    AQUARELLE_ON_PAPER("aquarelle_on_paper", 4),
    BLACK_CERAMIC("black_ceramic", 5),
    BRASS("brass", 5),
    BRONZE("bronze", 6),
    C_PRINT("c_print", 7),
    DIGITAL_COLLAGE("digital_collage", 8),
    EMBROIDERY("embroidery", 9),
    FIBERGLASS("fiberglass", 10),
    INK_ON_CANVAS("ink_on_canvas", 11),
    INK_ON_PAPER("ink_on_paper", 12),
    MARKER_ON_GLASS("marker_on_glass", 13),
    METAL("metal", 14),
    MIXED_TECHNIQUE("mixed_techique", 15),
    OIL_IN_CANVAS("oil_in_canvas", 16),
    OIL_IN_LINEN("oil_in_linen", 17),
    OIL_ON_CANVAS("oil_on_canvas", 18),
    OIL_ON_LINE("oil_on_line", 19),
    OIL_ON_LINEN("oil_on_linen", 20),
    PAINTED_CERAMICS("painted_ceramics", 21),
    PENCIL_ON_PAPER("pencil_on_paper", 22),
    PLASTER("plaster", 23),
    RESIN("resin", 24),
    SILICONE("silicone", 25),
    SPRAY_ON_CANVAS("spray_on_canvas", 26),
    TAPESTRY("tapestry", 27),
    WATERCOLOR_ON_PAPER("watercolor_on_paper", 28),
    WAX("wax", 29),
    WOOD("wood", 30),
    NONE("none", 31);

    private final String typeString;
    private final Integer id;
    public static Materials getEnumByFieldString(String field) {
        return Arrays.stream(Materials.values())
                .filter(enumElement -> enumElement.getTypeString().equals(field))
                .findAny()
                .orElse(NONE);
    }
}
