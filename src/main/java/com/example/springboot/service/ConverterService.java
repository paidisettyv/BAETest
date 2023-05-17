package com.example.springboot.service;

public interface ConverterService {

  Long convertRomanNumeralToDecimal(String romanNumeral);

  String convertDecimalToRomanNumeral(Long decimal);
}
