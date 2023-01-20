package dn.rubtsov.sockswarehouseapp.converter;

import dn.rubtsov.sockswarehouseapp.model.Color;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ColorConverter implements Converter<String, Color> {

    @Override
    public Color convert(String source) {
        return Color.convertColor(source);
    }
}
