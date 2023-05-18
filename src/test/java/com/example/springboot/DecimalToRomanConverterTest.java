package com.example.springboot;

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
        Long value = 10L;
        String expected = "X";
        // Act
        String actual = converterServiceImpl.convertDecimalToRomanNumeral(value);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnRomanNumeralMMMCMXCIX_whenConvertingDecimalToRoman_given3999() {
        // Arrange
        Long value = 3999L;
        String expected = "MMMCMXCIX";
        // Act
        String actual = converterServiceImpl.convertDecimalToRomanNumeral(value);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnCD_whenconvertedRomanNumeralToDecimal_given400() {
        // Arrange
        String expected = "CD";
        Long value = 400L;

        // Act
        String actual = converterServiceImpl.convertDecimalToRomanNumeral(value);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnRomanNumeralMMMDCCCLXXXVIII_whenconvertingDecimalToRomanNumeral_given3888() {
        // Arrange
        String expected = "MMMDCCCLXXXVIII";
        Long value = 3888L;

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
        Long actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }
}
