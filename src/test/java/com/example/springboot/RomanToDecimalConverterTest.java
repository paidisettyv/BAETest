package com.example.springboot;

import com.example.springboot.service.ConverterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RomanToDecimalConverterTest {

    @InjectMocks
    private ConverterService ConverterServiceImpl;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRomanToDecimal_III() {
        // Arrange
        String romanNumeral = "III";
        int expected = 3;

        // Act
        Long actual = ConverterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRomanToDecimal_IX() {
        // Arrange
        String romanNumeral = "IX";
        int expected = 9;

        // Act
        Long actual = ConverterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRomanToDecimal_LVIII() {
        // Arrange
        String romanNumeral = "LVIII";
        int expected = 58;

        // Act
        Long actual = ConverterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRomanToDecimal_MCMXCIV() {
        // Arrange
        String romanNumeral = "MCMXCIV";
        int expected = 1994;

        // Act
        Long actual = ConverterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRomanToDecimal_CD() {
        // Arrange
        String romanNumeral = "CD";
        int expected = 400;

        // Act
        Long actual = ConverterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRomanToDecimal_MMCDXXI() {
        // Arrange
        String romanNumeral = "MMCDXXI";
        int expected = 2421;

        // Act
        Long actual = ConverterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRomanToDecimal_XC() {
        // Arrange
        String romanNumeral = "XC";
        int expected = 90;

        // Act
        Long actual = ConverterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testRomanToDecimal_VIII() {
        // Arrange
        String romanNumeral = "VIII";
        int expected = 8;

        // Act
        Long actual = ConverterServiceImpl.convertRomanNumeralToDecimal(romanNumeral);

        // Assert
        assertEquals(expected, actual);
    }
}
