package com.example.springboot.service;

import com.example.springboot.service.ConverterService;
import com.example.springboot.service.impl.ConverterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DecimalToRomanConverterTest {
    private ConverterService converterServiceImpl;

    @BeforeEach
    void setup() {
        converterServiceImpl = new ConverterServiceImpl();
    }

    @Test
    public void shouldReturnRomanNumeralX_whenConvertingDecimalToRoman_givenDecimal10() {
        // Arrange
        int value = 10;
        String expected = "X";
        // Act
        String actual = converterServiceImpl.convertDecimalToRomanNumeral(value);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnRomanNumeralMMMCMXCIX_whenConvertingDecimalToRoman_given3999() {
        // Arrange
        int value = 3999;
        String expected = "MMMCMXCIX";
        // Act
        String actual = converterServiceImpl.convertDecimalToRomanNumeral(value);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnCD_whenConvertingRomanNumeralToDecimal_given400() {
        // Arrange
        String expected = "CD";
        int value = 400;
        // Act
        String actual = converterServiceImpl.convertDecimalToRomanNumeral(value);
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnRomanNumeralMMMDCCCLXXXVIII_whenConvertingDecimalToRomanNumeral_given3888() {
        // Arrange
        String expected = "MMMDCCCLXXXVIII";
        int value = 3888;
        // Act
        String actual = converterServiceImpl.convertDecimalToRomanNumeral(value);
        // Assert
        assertEquals(expected, actual);
    }


    @Test
    public void shouldReturnRomanNumeralMCMXCIV_whenConvertingDecimaltoRoman_given1994() {
        // Arrange
        String romanNumeral = "MCMXCIV";
        int expected = 1994;

        // Act
        int actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }
}
