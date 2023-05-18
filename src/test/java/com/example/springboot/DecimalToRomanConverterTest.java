package com.example.springboot;

import com.example.springboot.service.ConverterService;
import com.example.springboot.service.impl.ConverterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecimalToRomanConverterTest {
    private ConverterService converterServiceImpl;

    @BeforeEach
    void setup() {
        converterServiceImpl = new ConverterServiceImpl();
    }

    @Test
    public void shouldReturnRomanNumeralX_whenConvertingDecimalToRoman_givenX() {
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

}
