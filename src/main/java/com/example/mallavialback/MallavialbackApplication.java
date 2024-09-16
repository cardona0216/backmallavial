package com.example.mallavialback;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class MallavialbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallavialbackApplication.class, args);
	}

	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	


}
