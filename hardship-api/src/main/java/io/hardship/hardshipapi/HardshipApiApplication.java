package io.hardship.hardshipapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"io.hardship.hardshipapi.dao", "io.hardship.hardshipapi.controller","io.hardship.hardshipapi.service"})
public class HardshipApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(HardshipApiApplication.class, args);
	}

}
