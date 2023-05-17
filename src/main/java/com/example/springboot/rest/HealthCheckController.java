package com.example.springboot.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

  public HealthCheckController() {
  }

  @GetMapping()
  public ResponseEntity<String> isHealthy() {
    return ResponseEntity.ok("Health OK");
  }

}
