package by.kurapatsin.dateconversiontest.json;

import by.kurapatsin.dateconversiontest.util.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;

public class XMLGregorianCalendarSerializer extends JsonSerializer<XMLGregorianCalendar> {

    @Override
    public void serialize(final XMLGregorianCalendar value,
                          final JsonGenerator jsonGenerator,
                          final SerializerProvider serializers) throws IOException {
        jsonGenerator.writeString(DateUtils.SIMPLE_DATE_TIME_FORMAT.format(value.toGregorianCalendar().getTime()));
    }
}
