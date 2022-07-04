package io.hardship.hardshipapi;
import io.hardship.hardshipapi.service.FilesStorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
@ComponentScan({"io.hardship.hardshipapi.dao", "io.hardship.hardshipapi.controller","io.hardship.hardshipapi.service"})
public class HardshipApiApplication  {

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(HardshipApiApplication.class, args);
	}



}
