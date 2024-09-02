package by.kurapatsin.dateconversiontest.config;

import by.kurapatsin.dateconversiontest.json.DateDeserializer;
import by.kurapatsin.dateconversiontest.json.InstantDeserializer;
import by.kurapatsin.dateconversiontest.json.InstantSerializer;
import by.kurapatsin.dateconversiontest.json.SqlDateDeserializer;
import by.kurapatsin.dateconversiontest.json.SqlDateSerializer;
import by.kurapatsin.dateconversiontest.json.DateSerializer;
import by.kurapatsin.dateconversiontest.json.LocalDateDeserializer;
import by.kurapatsin.dateconversiontest.json.LocalDateSerializer;
import by.kurapatsin.dateconversiontest.json.LocalDateTimeDeserializer;
import by.kurapatsin.dateconversiontest.json.LocalDateTimeSerializer;
import by.kurapatsin.dateconversiontest.json.XMLGregorianCalendarDeserializer;
import by.kurapatsin.dateconversiontest.json.XMLGregorianCalendarSerializer;
import by.kurapatsin.dateconversiontest.json.ZonedDateTimeDeserializer;
import by.kurapatsin.dateconversiontest.json.ZonedDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Configuration
public class ObjectMapperConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        final SimpleModule customSerializers = new SimpleModule("CustomSerializers");
        customSerializers.addSerializer(java.util.Date.class, new DateSerializer());
        customSerializers.addDeserializer(java.util.Date.class, new DateDeserializer());
        customSerializers.addSerializer(java.sql.Date.class, new SqlDateSerializer());
        customSerializers.addDeserializer(java.sql.Date.class, new SqlDateDeserializer());
        customSerializers.addSerializer(LocalDate.class, new LocalDateSerializer());
        customSerializers.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        customSerializers.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        customSerializers.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        customSerializers.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer());
        customSerializers.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
        customSerializers.addSerializer(Instant.class, new InstantSerializer());
        customSerializers.addDeserializer(Instant.class, new InstantDeserializer());
        customSerializers.addSerializer(XMLGregorianCalendar.class, new XMLGregorianCalendarSerializer());
        customSerializers.addDeserializer(XMLGregorianCalendar.class, new XMLGregorianCalendarDeserializer());
        return new Jackson2ObjectMapperBuilder()
                .modules(customSerializers)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .featuresToEnable(SerializationFeature.INDENT_OUTPUT)
                .featuresToDisable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
                .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .serializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
