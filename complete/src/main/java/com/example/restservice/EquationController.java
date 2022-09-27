package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EquationController {


	@GetMapping("/equation")
	public Response equation(
							 @RequestParam(value = "a", defaultValue = "1") int a,
							 @RequestParam(value = "b", defaultValue = "6") int b,
							 @RequestParam(value = "c", defaultValue = "0") int c ) {

		return new Equation().resolve(a,b,c);
	}
}
