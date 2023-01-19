package dn.rubtsov.sockswarehouseapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import dn.rubtsov.sockswarehouseapp.exception.IncorrectDataExceptiom;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Color {

    WHITE("белый"), BLACK("чёрный"), RED("красный");
    private final String text;

    Color(String text) {
        this.text = text;
    }

    @JsonValue
    public String getText() {
        return text;
    }
    @JsonCreator
    public static Color convertColor(String source) {
        for (Color color : Color.values()) {
                if (source.equals(color.text)) {
                    return color;
                }
            }
        throw new IncorrectDataExceptiom("Такого цвета нет в ассортименте склада.");
    }
}
