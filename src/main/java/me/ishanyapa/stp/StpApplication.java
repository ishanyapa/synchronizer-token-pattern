package me.ishanyapa.stp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:WebContentInterceptor.xml")
public class StpApplication {

	public static void main(String[] args) {
		SpringApplication.run(StpApplication.class, args);
	}
}
