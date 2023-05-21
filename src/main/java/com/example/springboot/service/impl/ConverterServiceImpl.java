package com.example.springboot.service.impl;

import com.example.springboot.service.ConverterService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ConverterServiceImpl implements ConverterService {

  private final static Map<Integer, String> decimalToRomanMap;
  private final static Map<Character, Integer> romanToDecimalMap;

  // Instantiating the static map
  static {
    decimalToRomanMap = new LinkedHashMap<>(); // To maintain order
    decimalToRomanMap.put(1000, "M");
    decimalToRomanMap.put(900, "CM");
    decimalToRomanMap.put(500, "D");
    decimalToRomanMap.put(400, "CD");
    decimalToRomanMap.put(100, "C");
    decimalToRomanMap.put(90, "XC");
    decimalToRomanMap.put(50, "L");
    decimalToRomanMap.put(40, "XL");
    decimalToRomanMap.put(10, "X");
    decimalToRomanMap.put(9, "IX");
    decimalToRomanMap.put(5, "V");
    decimalToRomanMap.put(4, "IV");
    decimalToRomanMap.put(1, "I");

    romanToDecimalMap = new HashMap<>();
    romanToDecimalMap.put('I', 1);
    romanToDecimalMap.put('V', 5);
    romanToDecimalMap.put('X', 10);
    romanToDecimalMap.put('L', 50);
    romanToDecimalMap.put('C', 100);
    romanToDecimalMap.put('D', 500);
    romanToDecimalMap.put('M', 1000);
  }

  @Override
  public int convertRomanNumeralToDecimal(String romanNumeral) {
    int result=0;
    for(int i=0; i<romanNumeral.length(); i++){
      if(i+1< romanNumeral.length() && romanToDecimalMap.get(romanNumeral.charAt(i)) < romanToDecimalMap.get(romanNumeral.charAt(i+1)))
        result-=romanToDecimalMap.get(romanNumeral.charAt(i));
      else
        result+=romanToDecimalMap.get(romanNumeral.charAt(i));
    }
    return result;
  }

  @Override
  public String convertDecimalToRomanNumeral(int decimal) {

    if (decimalToRomanMap.containsKey(decimal)) {
      return decimalToRomanMap.get(decimal);
    }
    StringBuilder romanNumeral = new StringBuilder();
    for (Map.Entry<Integer, String> entry : decimalToRomanMap.entrySet()) {
      int decimalVal = entry.getKey();
      String romanSymbol = entry.getValue();

      while (decimal >= decimalVal) {
        romanNumeral.append(romanSymbol);
        decimal -= decimalVal;
      }
    }
    return romanNumeral.toString();
  }
}
