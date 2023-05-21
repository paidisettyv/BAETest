package com.example.springboot.service;

public interface ConverterService {

  int convertRomanNumeralToDecimal(String romanNumeral);

  String convertDecimalToRomanNumeral(int decimal);
}
