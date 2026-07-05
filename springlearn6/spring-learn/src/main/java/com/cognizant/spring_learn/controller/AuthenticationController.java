package com.cognizant.spring_learn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

	@GetMapping("/authenticate")
	public Map<String, String> authenticate() {

	    String token = Jwts.builder()
	            .setSubject("user")
	            .signWith(SignatureAlgorithm.HS256, "secretkey")
	            .compact();

	    Map<String, String> response = new HashMap<>();

	    response.put("token", token);

	    return response;
	}
}