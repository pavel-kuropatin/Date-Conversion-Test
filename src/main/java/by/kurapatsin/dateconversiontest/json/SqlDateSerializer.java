package by.kurapatsin.dateconversiontest.json;

import by.kurapatsin.dateconversiontest.util.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.sql.Date;

public class SqlDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(final Date value,
                          final JsonGenerator jsonGenerator,
                          final SerializerProvider serializers) throws IOException {
        jsonGenerator.writeString(DateUtils.SIMPLE_DATE_FORMAT.format(value));
    }
}
