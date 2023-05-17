package com.example.springboot.rest;

import com.example.springboot.service.ConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping
public class ConverterController {

  private ConverterService converterService;

  @Inject
  public ConverterController(ConverterService converterService) {
    this.converterService = converterService;
  }

  @GetMapping(path = "/romanNumeralToDecimal/{numeral}")
  public ResponseEntity<?> getDecimal(@PathVariable String numeral){
    try {
      return ResponseEntity.ok(converterService.convertRomanNumeralToDecimal(numeral));
    }
    catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/decimalToRomanNumeral/{decimal}")
  public ResponseEntity<?> getRomanNumeral(@PathVariable Long decimal){
    try {
      if (decimal <= 0 || decimal > 3999) {
        return ResponseEntity.badRequest().body("Invalid decimal, please send a value between 1 and 3 ");
      }
      return ResponseEntity.ok(converterService.convertDecimalToRomanNumeral(decimal));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), INTERNAL_SERVER_ERROR);
    }
  }
}
