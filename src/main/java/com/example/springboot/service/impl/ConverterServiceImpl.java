package com.example.springboot.service.impl;

import com.example.springboot.service.ConverterService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ConverterServiceImpl implements ConverterService {

  private final static Map<Long, String> decimalToRomanMap;
  private final static Map<Character, Long> romanToDecimalMap;

  // Instantiating the static map
  static {
    decimalToRomanMap = new LinkedHashMap<>(); // To maintain order
    decimalToRomanMap.put(1000l, "M");
    decimalToRomanMap.put(900l, "CM");
    decimalToRomanMap.put(500l, "D");
    decimalToRomanMap.put(400l, "CD");
    decimalToRomanMap.put(100l, "C");
    decimalToRomanMap.put(90l, "XC");
    decimalToRomanMap.put(50l, "L");
    decimalToRomanMap.put(40l, "XL");
    decimalToRomanMap.put(10l, "X");
    decimalToRomanMap.put(9l, "IX");
    decimalToRomanMap.put(5l, "V");
    decimalToRomanMap.put(4l, "IV");
    decimalToRomanMap.put(1l, "I");

    romanToDecimalMap = new HashMap<>();
    romanToDecimalMap.put('I', 1l);
    romanToDecimalMap.put('V', 5l);
    romanToDecimalMap.put('X', 10l);
    romanToDecimalMap.put('L', 50l);
    romanToDecimalMap.put('C', 100l);
    romanToDecimalMap.put('D', 500l);
    romanToDecimalMap.put('M', 1000l);
  }

  @Override
  public Long convertRomanNumeralToDecimal(String romanNumeral) {
    long result=0;
    for(int i=0; i<romanNumeral.length(); i++){
      if(i+1< romanNumeral.length() && romanToDecimalMap.get(romanNumeral.charAt(i)) < romanToDecimalMap.get(romanNumeral.charAt(i+1)))
        result-=romanToDecimalMap.get(romanNumeral.charAt(i));
      else
        result+=romanToDecimalMap.get(romanNumeral.charAt(i));
    }
    return result;
  }

  @Override
  public String convertDecimalToRomanNumeral(Long decimal) {

    if (decimalToRomanMap.containsKey(decimal)) {
      return decimalToRomanMap.get(decimal);
    }
    StringBuilder romanNumeral = new StringBuilder();
    for (Map.Entry<Long, String> entry : decimalToRomanMap.entrySet()) {
      Long decimalVal = entry.getKey();
      String romanSymbol = entry.getValue();

      while (decimal >= decimalVal) {
        romanNumeral.append(romanSymbol);
        decimal -= decimalVal;
      }
    }
    return romanNumeral.toString();
  }
}
