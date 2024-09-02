package by.kurapatsin.dateconversiontest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DateModel {

    private java.util.Date javaDate;
    private java.sql.Date sqlDate;
    private LocalDate localDate;
    private LocalDateTime localDateTime;
    private ZonedDateTime zonedDateTime;
    private Instant instant;
    private XMLGregorianCalendar xmlGregorianCalendar;

    public static DateModel now() {
        try {
            return DateModel.builder()
                    .javaDate(new java.util.Date())
                    .sqlDate(new java.sql.Date(System.currentTimeMillis()))
                    .localDate(LocalDate.now())
                    .localDateTime(LocalDateTime.now())
                    .zonedDateTime(ZonedDateTime.now())
                    .instant(Instant.now())
                    .xmlGregorianCalendar(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()))
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
