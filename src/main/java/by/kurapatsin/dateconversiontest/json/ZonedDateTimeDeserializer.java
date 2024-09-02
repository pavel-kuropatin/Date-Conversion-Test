package by.kurapatsin.dateconversiontest.json;

import by.kurapatsin.dateconversiontest.util.DateUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    @Override
    public ZonedDateTime deserialize(final JsonParser jsonParser,
                                     final DeserializationContext deserializationContext) throws IOException {
        return DateUtils.DESERIALIZATION_ISO_DATE_TIME_FORMATTER.parse(jsonParser.getValueAsString(),
                LocalDateTime::from).atZone(DateUtils.UTC_ZONE_ID);
    }
}
