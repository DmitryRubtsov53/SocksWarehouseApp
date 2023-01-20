package dn.rubtsov.sockswarehouseapp.converter;

import dn.rubtsov.sockswarehouseapp.model.Size;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SizeConverter implements Converter <String, Size> {

    @Override
    public Size convert(String source) {
        return Size.convertSize(source);
    }
}
