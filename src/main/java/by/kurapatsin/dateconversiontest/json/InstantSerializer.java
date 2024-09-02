package by.kurapatsin.dateconversiontest.json;

import by.kurapatsin.dateconversiontest.util.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class InstantSerializer extends JsonSerializer<Instant> {

    @Override
    public void serialize(final Instant value,
                          final JsonGenerator jsonGenerator,
                          final SerializerProvider serializerProvider) throws IOException {
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(value, ZoneOffset.UTC);
        jsonGenerator.writeString(DateUtils.SERIALIZATION_ISO_DATE_TIME_FORMATTER.format(localDateTime));
    }
}
