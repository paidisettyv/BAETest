package com.example.springboot;

import com.example.springboot.service.ConverterService;
import com.example.springboot.service.impl.ConverterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RomanToDecimalConverterTest {
    private ConverterService converterServiceImpl;

    @BeforeEach
    void setup() {
        converterServiceImpl = new ConverterServiceImpl();
    }

    @Test
    public void shouldReturn3_whenconvertedRomanNumeralToDecimal_givenIII() {
        // Arrange
        String romanNumeral = "III";
        int expected = 3;
        // Act
        Long actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn3888_whenconvertedRomanNumeralToDecimal_givenMMMDCCCLXXXVIII() {
        // Arrange
        String romanNumeral = "MMMDCCCLXXXVIII";
        int expected = 3888;

        // Act
        Long actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }


    @Test
    public void shouldReturn3999_whenconvertedRomanNumeralToDecimal_givenMMMCMXCIX() {
        // Arrange
        String romanNumeral = "MMMCMXCIX";
        int expected = 3999;

        // Act
        Long actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMinusOne_whenConvertingRomanToDecimal_givenStringA(){
        // Arrange
        String romanNumeral = "A";
        int expected = -1;

        // Act
        Long actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnMinusOne_whenConvertingRomanToDecimal_givenEmptyString(){
        // Arrange
        String romanNumeral = "";
        int expected = -1;

        // Act
        Long actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnMinusOne_whenConvertingRomanToDecimal_givenStringGreaterThan15(){
        // Arrange
        String romanNumeral = "MMMDCCCLXXXVIIII";
        int expected = -1;

        // Act
        Long actual = converterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }
}
