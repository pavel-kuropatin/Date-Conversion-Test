package by.kurapatsin.dateconversiontest.mapper;

import by.kurapatsin.dateconversiontest.dto.DateModelDto;
import by.kurapatsin.dateconversiontest.model.DateModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DateModelMapper {

    DateModel toDateModel(DateModelDto dto);

    DateModelDto toDateModelDto(DateModel dateModel);
}
