package com.example.springboot.service;

import com.example.springboot.service.impl.ConverterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToDecimalConverterTest {
    private ConverterService converterServiceImpl;

    @BeforeEach
    void setup() {
        converterServiceImpl = new ConverterServiceImpl();
    }

    @Test
    public void shouldReturnDecimalThree_whenConvertingRomanNumeralToDecimal_givenNumeralIII() {
        // Arrange
        String romanNumeral = "III";
        int expected = 3;
        // Act
        int actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnDecimal1994_whenConvertingRomanNumeralToDecimal_givenNumeralMCMXCIV() {
        // Arrange
        String romanNumeral = "MCMXCIV";
        int expected = 1994;
        // Act
        int actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDecimalFourHundred_whenConvertingRomanNumeralToDecimal_givenNumeralCD() {
        // Arrange
        String romanNumeral = "CD";
        int expected = 400;
        // Act
        int actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnDecimal3888_whenConvertingRomanNumeralToDecimal_givenNumeralMMMDCCCLXXXVIII() {
        // Arrange
        String romanNumeral = "MMMDCCCLXXXVIII";
        int expected = 3888;
        // Act
        int actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);
        // Assert
        assertEquals(expected, actual);
    }


    @Test
    public void shouldReturnDecimal3999_whenConvertingRomanNumeralToDecimal_givenNumeralMMMCMXCIX() {
        // Arrange
        String romanNumeral = "MMMCMXCIX";
        int expected = 3999;
        // Act
        int actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);
        // Assert
        assertEquals(expected, actual);
    }

}
