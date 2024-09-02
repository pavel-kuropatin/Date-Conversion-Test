package by.kurapatsin.dateconversiontest.controller;

import by.kurapatsin.dateconversiontest.dto.DateModelDto;
import by.kurapatsin.dateconversiontest.model.DateModel;
import by.kurapatsin.dateconversiontest.service.DateConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/date-conversion-test")
@RequiredArgsConstructor
public class DateConversionController {

    private final DateConversionService dateConversionService;

    @GetMapping(path = "/get-dates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DateModel> getDates() {
        return ResponseEntity.ok(DateModel.now());
    }

    @PostMapping(path = "/get-date-model", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DateModel> getDateModel(@RequestBody DateModelDto dateModelDto) {
        return ResponseEntity.ok(dateConversionService.getDateModel(dateModelDto));
    }
}
