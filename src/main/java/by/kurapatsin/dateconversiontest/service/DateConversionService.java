package by.kurapatsin.dateconversiontest.service;

import by.kurapatsin.dateconversiontest.dto.DateModelDto;
import by.kurapatsin.dateconversiontest.mapper.DateModelMapper;
import by.kurapatsin.dateconversiontest.model.DateModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class DateConversionService {

    private final DateModelMapper dateModelMapper;

    public DateModel getDateModel(final DateModelDto dto) {
        return dateModelMapper.toDateModel(dto);
    }

    public DateModelDto getDateModelDto(final DateModel testModel) {
        return dateModelMapper.toDateModelDto(testModel);
    }
}
