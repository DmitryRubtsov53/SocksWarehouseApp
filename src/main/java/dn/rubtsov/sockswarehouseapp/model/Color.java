package dn.rubtsov.sockswarehouseapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

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
    @JsonCreator    //  Проблема где-то здесь???
    public static Color forValues(String color) {
        try {
            for (Color el : Color.values()) {
                if (color.equals(el.text)) {
                    return el;
                }
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }
}
