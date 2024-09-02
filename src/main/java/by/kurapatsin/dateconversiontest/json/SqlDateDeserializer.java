package by.kurapatsin.dateconversiontest.json;

import by.kurapatsin.dateconversiontest.util.DateUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class SqlDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(final JsonParser jsonParser,
                            final DeserializationContext deserializationContext) throws IOException {
        return Date.valueOf(DateUtils.DESERIALIZATION_ISO_DATE_FORMATTER.parse(jsonParser.getValueAsString(), LocalDate::from));
    }
}
