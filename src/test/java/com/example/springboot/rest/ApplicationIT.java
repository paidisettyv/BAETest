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
public class ApplicationIT {

  final TestRestTemplate restTemplate = new TestRestTemplate();
  @LocalServerPort
  private int port;

  @Test
  public void testHealthCheck() throws NullPointerException {
    ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/health", String.class);

    assertTrue("200 Response code is expected", response.getStatusCode().is2xxSuccessful());
    assertTrue("Health check failed", Objects.equals(response.getBody(), "Health OK"));
  }
}