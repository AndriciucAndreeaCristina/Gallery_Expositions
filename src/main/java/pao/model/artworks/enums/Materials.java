package pao.model.artworks.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Materials {
    ACRYLIC_ON_CANVAS ("acrylic_on_canvas"),
    ACRYLIC_ON_PAPER ("acrylic_on_paper"),
    ACRYLIC_ON_WOOD ("acrylic_on_wood"),
    ACRYLIC_ON_GLASS("acrylic_on_glass"),
    AQUARELLE_ON_PAPER("aquarelle_on_paper"),
    BLACK_CERAMIC("black_ceramic"),
    BRASS("brass"),
    BRONZE("bronze"),
    C_PRINT("c_print"),
    DIGITAL_COLLAGE("digital_collage"),
    EMBROIDERY("embroidery"),
    FIBERGLASS("fiberglass"),
    INK_ON_CANVAS("ink_on_canvas"),
    INK_ON_PAPER("ink_on_paper"),
    MARKER_ON_GLASS("marker_on_glass"),
    METAL("metal"),
    MIXED_TECHNIQUE("mixed_techique"),
    OIL_IN_CANVAS("oil_in_canvas"),
    OIL_IN_LINEN("oil_in_linen"),
    OIL_ON_CANVAS("oil_on_canvas"),
    OIL_ON_LINE("oil_on_line"),
    OIL_ON_LINEN("oil_on_linen"),
    PAINTED_CERAMICS("painted_ceramics"),
    PENCIL_ON_PAPER("pencil_on_paper"),
    PLASTER("plaster"),
    RESIN("resin"),
    SILICONE("silicone"),
    SPRAY_ON_CANVAS("spray_on_canvas"),
    TAPESTRY("tapestry"),
    WATERCOLOR_ON_PAPER("watercolor_on_paper"),
    WAX("wax"),
    WOOD("wood"),
    NONE("none");

    private final String typeString;
    public static Materials getEnumByFieldString(String field) {
        return Arrays.stream(Materials.values())
                .filter(enumElement -> enumElement.getTypeString().equals(field))
                .findAny()
                .orElse(NONE);
    }
}
