package com.example.springboot.rest;

import com.example.springboot.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConverterControllerIT {

    final TestRestTemplate restTemplate = new TestRestTemplate();
    @LocalServerPort
    private int port;

    private final String LOCALHOST = "http://localhost:";

    @Test
    void shouldReturn10_WhenConvertingRomanToDecimal_givenNumeralX() {
        //Arrange
        String romanNumeral = "X";
        String expected = "10";
        //Act
        ResponseEntity<String> response = restTemplate.getForEntity(LOCALHOST + port + "/romanNumeralToDecimal/"+romanNumeral, String.class);
        //Assert
        assertTrue("200 Response code is expected", response.getStatusCode().is2xxSuccessful());
        assertTrue("Converting Roman to Decimal Failed", Objects.equals(response.getBody(), expected));
    }

    @Test
    void shouldReturnInvalidMessage_WhenConvertingRomanToDecimal_givenNumeralA() {
        //Arrange
        String romanNumeral = "A";
        String expected = "Invalid roman numeral, should contain only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')";
        //Act
        ResponseEntity<String> response = restTemplate.getForEntity(LOCALHOST + port + "/romanNumeralToDecimal/"+romanNumeral, String.class);
        //Assert
        assertTrue("400 Response code is expected", response.getStatusCode().is4xxClientError());
        assertTrue("Should return " + expected, Objects.equals(response.getBody(), expected));
    }
    @Test
    void shouldReturnInvalidMessage_WhenConvertingRomanToDecimal_givenNumeralABCDEFGDGDSGADGSGD() {
        //Arrange
        String romanNumeral = "ABCDEFGDGDSGADGSGD";
        String expected = "Invalid roman numeral, should be less than 15";
        //Act
        ResponseEntity<String> response = restTemplate.getForEntity(LOCALHOST + port + "/romanNumeralToDecimal/"+romanNumeral, String.class);
        //Assert
        assertTrue("400 Response code is expected", response.getStatusCode().is4xxClientError());
        assertTrue("Should return " + expected, Objects.equals(response.getBody(), expected));
    }
    @Test
    void shouldReturnInvalidMessage_WhenConvertingRomanToDecimal_givenNumeralx() throws NullPointerException{
        //Arrange
        String romanNumeral = "x";
        String expected = "Invalid roman numeral, should contain only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')";
        //Act
        ResponseEntity<String> response = restTemplate.getForEntity(LOCALHOST + port + "/romanNumeralToDecimal/"+romanNumeral, String.class);
        //Assert
        assertTrue("400 Response code is expected", response.getStatusCode().is4xxClientError());
        assertTrue("Should return " + expected, Objects.equals(response.getBody(), expected));
    }

    @Test
    void ShouldReturnRomanNumeralX_WhenConvertingDecimalToRoman_givenDecimalTen() {
        //Arrange
        int decimal = 10;
        String expected = "X";
        //Act
        ResponseEntity<String> response = restTemplate.getForEntity(LOCALHOST + port + "/decimalToRomanNumeral/"+decimal, String.class);
        //Assert
        assertTrue("200 Response code is expected", response.getStatusCode().is2xxSuccessful());
        assertTrue("Should return " + expected, Objects.equals(response.getBody(), expected));
    }
    @Test
    void ShouldReturnInvalidDecimal_WhenConvertingDecimalToRoman_givenDecimalZero() {
        //Arrange
        int decimal = 0;
        String expected = "Invalid decimal, please send a value between 1 and 3999";
        //Act
        ResponseEntity<String> response = restTemplate.getForEntity(LOCALHOST + port + "/decimalToRomanNumeral/"+decimal, String.class);
        //Assert
        assertTrue("400 Response code is expected", response.getStatusCode().is4xxClientError());
        assertTrue("Should return " + expected, Objects.equals(response.getBody(), expected));
    }
    @Test
    void ShouldReturnInvalidDecimal_WhenConvertingDecimalToRoman_givenDecimal4000() {
        //Arrange
        int decimal = 4000;
        String expected = "Invalid decimal, please send a value between 1 and 3999";
        //Act
        ResponseEntity<String> response = restTemplate.getForEntity(LOCALHOST + port + "/decimalToRomanNumeral/"+decimal, String.class);
        //Assert
        assertTrue("400 Response code is expected", response.getStatusCode().is4xxClientError());
        assertTrue("Should return " + expected, Objects.equals(response.getBody(), expected));
    }

}
