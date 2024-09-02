package by.kurapatsin.dateconversiontest.json;

import by.kurapatsin.dateconversiontest.util.DateUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class DateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(final JsonParser jsonParser,
                            final DeserializationContext deserializationContext) throws IOException {
        return Date.from(DateUtils.DESERIALIZATION_ISO_DATE_TIME_FORMATTER.parse(jsonParser.getValueAsString(),
                LocalDateTime::from).atOffset(ZoneOffset.ofHours(+3)).toInstant());
    }
}
