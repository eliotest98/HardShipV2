package io.hardship.hardshipapi;

import io.hardship.hardshipapi.dao.GestioneUtenteDao;
import io.hardship.hardshipapi.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HardshipApiApplication {
	@Autowired
	GestioneUtenteDao gestioneUtenteDao;

	@GetMapping("/test")
	public String test(){
		String nome = "Pippo";
		String cognome = "Pluto";
		String user = "allor";

		String cf = "asdped120jdla";
		String data = "20-10-95";
		String email = "test@test.it";
		String password = "hola";


		Cliente cliente = new Cliente(nome, cognome, data, user, password, cf, email);

		gestioneUtenteDao.save(cliente);
		return "Hello";
	}


	public static void main(String[] args) {
		SpringApplication.run(HardshipApiApplication.class, args);
	}

}
