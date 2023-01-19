package dn.rubtsov.sockswarehouseapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import dn.rubtsov.sockswarehouseapp.exception.IncorrectDataExceptiom;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Size {

// Обозначения по европейскому (S-XXL) и российскому (23-31) стандартам обозначения размера носков:
    S("23"), M("25"), L("27"), XL("29"), XXl("31");

    private final String ruSize;

    Size(String ruSize) {
        this.ruSize = ruSize;
    }

    @JsonValue
    public String getNumber() {
        return ruSize;
    }
    @JsonCreator
    public static Size convertSize(String source) {
           for (Size size : Size.values()) {
                if (source.equals(size.ruSize)) {
                    return size;
                }
            }
        throw new IncorrectDataExceptiom("Такой размер не существует.");
    }
}
