package com.example.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/info")
	public String getInfo() {
		return "This application provides REST endpoints to convert Roman numerals to decimal and vice versa. " +
				"To convert a Roman numeral to decimal, use http://localhost:8080/romanNumeralToDecimal/{numeral}, " +
				"where {numeral} is the Roman numeral you want to convert. " +
				"To convert a decimal to Roman numeral, use the endpoint http://localhost:8080/decimalToRomanNumeral/{decimal}, " +
				"where {decimal} is the decimal value you want to convert. ";
	}
}
