package dn.rubtsov.sockswarehouseapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Size {

    S("23"), M("27"), L("27"), XL("29"), XXl("31");

    private final String number;

    Size(String number) {
        this.number = number;
    }

    @JsonValue
    public String getNumber() {
        return number;
    }
    @JsonCreator    // Проблема где-то здесь???
    public static Size forValues(String size) {
        try {
            for (Size el : Size.values()) {
                if (size.equals(el.number)) {
                    return el;
                }
            }
        }catch (Exception e) {
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }
}
