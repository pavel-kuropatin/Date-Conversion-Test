package by.kurapatsin.dateconversiontest.json;

import by.kurapatsin.dateconversiontest.util.DateUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.time.LocalDateTime;

public class XMLGregorianCalendarDeserializer extends JsonDeserializer<XMLGregorianCalendar> {

    @Override
    public XMLGregorianCalendar deserialize(final JsonParser jsonParser,
                                            final DeserializationContext deserializationContext) throws IOException {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(DateUtils.DESERIALIZATION_ISO_DATE_TIME_FORMATTER.parse(jsonParser.getValueAsString(), LocalDateTime::from).toString());
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
