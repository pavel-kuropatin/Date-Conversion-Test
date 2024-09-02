package by.kurapatsin.dateconversiontest.json;

import by.kurapatsin.dateconversiontest.util.DateUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class InstantDeserializer extends JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(final JsonParser jsonParser,
                               final DeserializationContext deserializationContext) throws IOException {
        return DateUtils.DESERIALIZATION_ISO_DATE_TIME_FORMATTER.parse(jsonParser.getValueAsString(),
                LocalDateTime::from).atOffset(ZoneOffset.UTC).toInstant();
    }
}
